--*******************************************************************************
--**  This file is made available under the terms of the Eclipse Public License v1.0
--**  which accompanies this distribution, and is available at
--**  http://www.eclipse.org/legal/epl-v10.html
--*******************************************************************************

--DROP INDEX payment_pk;
--DROP TABLE payment;

--TINYINT (-128 to +127), SMALLINT (–32,768 to 32,767), INTEGER (-2147483648 to 2147483647), BIGINT (-9223372036854775808 to 9223372036854775807), NUMERIC and DECIMAL 
-- = byte, short, int, long, BigDecimal and BigDecimal

DROP INDEX season_uix;
DROP TABLE season;

DROP INDEX skill_info_uix;
DROP TABLE skill_info;

DROP INDEX skill_uix;
DROP TABLE skill;

DROP INDEX player_role_uix;
DROP TABLE player_role;

DROP INDEX player_uix;
DROP TABLE player;

DROP INDEX scout_uix;
DROP TABLE scout;

DROP INDEX physio_uix;
DROP TABLE physio;

DROP INDEX manager_uix;
DROP TABLE manager;

DROP INDEX coach_uix;
DROP TABLE coach;

DROP INDEX contract_uix;
DROP TABLE contract;

DROP INDEX training_base_uix;
DROP TABLE training_base;

DROP INDEX physio_base_uix;
DROP TABLE physio_base;

DROP INDEX office_uix;
DROP TABLE office;

DROP INDEX stadium_uix;
DROP TABLE stadium;

DROP INDEX facility_info_uix;
DROP TABLE facility_info;

DROP INDEX player_position_uix;
DROP TABLE player_position;

DROP INDEX club_budget_uix;
DROP TABLE club_budget;

DROP INDEX club_uix;
DROP TABLE club;

DROP INDEX team_uix;
DROP TABLE team;

DROP INDEX league_level_uix;
DROP TABLE league_level;

DROP INDEX league_system_uix;
DROP TABLE league_system;

DROP INDEX league_uix;
DROP TABLE leagueSystem;

DROP INDEX person_uix;
DROP TABLE person;

DROP INDEX person_type_uix;
DROP TABLE person_type;

DROP INDEX nation_uix;
DROP TABLE nation;



-- ***************************************** COMMON **********************************************************************************

-- defines enum types like player, coach, scout, manager etc.
CREATE TABLE person_type(
	person_type_id INTEGER NOT NULL,
	name_key VARCHAR(30) NOT NULL
);
CREATE UNIQUE INDEX person_type_uix ON person_type(person_type_id);
ALTER TABLE person_type ADD CONSTRAINT person_type_pk PRIMARY KEY (person_type_id);

CREATE TABLE person(
	person_id INTEGER NOT NULL,
	birth DATE,
	first_name VARCHAR(20),
	last_name VARCHAR(20) NOT NULL,
	middle_name VARCHAR(20),
	name_prefix VARCHAR(20),
	name_suffix VARCHAR(20),
	nickname VARCHAR(20),
	morale TINYINT,
	reputation INTEGER,
	person_type_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX person_uix ON person(person_id);
ALTER TABLE person ADD PRIMARY KEY (person_id);
ALTER TABLE person ADD FOREIGN KEY (person_type_id) REFERENCES person_type(person_type_id);

CREATE TABLE nation(
	nation_id INTEGER NOT NULL,
	name_key VARCHAR(30) NOT NULL,
	capital_city VARCHAR(30),
	attendance_modifier TINYINT,
	money_level_modifier TINYINT -- for transfer values, wages, facil costs etc.
);
CREATE UNIQUE INDEX nation_uix ON nation (nation_id);
ALTER TABLE nation ADD CONSTRAINT nation_pk PRIMARY KEY (nation_id);

--TODO do we need CREATE TABLE nationality( ?? we'll see

CREATE TABLE person_nationality(
        person_id INTEGER NOT NULL,
        nation_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX person_nationality_uix ON person_nationality(person_id, nation_id);
ALTER TABLE person_nationality ADD CONSTRAINT person_nationality_pk PRIMARY KEY (person_id, nation_id);
ALTER TABLE person_nationality ADD FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE person_nationality ADD FOREIGN KEY (nation_id) REFERENCES nation(nation_id);


-- ***************************************** LEAGUE SYSTEM **********************************************************************************
-- Defines nation leagueSystem system like english leagueSystem, german leagueSystem...
CREATE TABLE league_system(
	league_system_id INTEGER NOT NULL,
	levels TINYINT,
	nation_id INTEGER NOT NULL
	-- top_league_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX league_system_uix on league_system(league_system_id);
ALTER TABLE league_system ADD CONSTRAINT league_system_pk PRIMARY KEY (league_system_id);
ALTER TABLE league_system ADD FOREIGN KEY (nation_id) REFERENCES nation(nation_id);

-- Defines one leagueSystem level in leagueSystem system like Premier League, Conference, Premier division etc.
CREATE TABLE league_level(
	league_level_id INTEGER NOT NULL,
	clubs_per_league TINYINT,
	promoted_clubs_count TINYINT,
	league_system_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX league_level_uix on league_level(league_level_id);
ALTER TABLE league_level ADD CONSTRAINT league_level_pk PRIMARY KEY (league_level_id);
ALTER TABLE league_level ADD FOREIGN KEY (league_system_id) REFERENCES league_system(league_system_id);

-- Defines one leagueSystem in leagueSystem level like Premier leagueSystem, Conference North, Northern Premier League Premier Division etc.
CREATE TABLE leagueSystem(
	league_id INTEGER NOT NULL,
	name VARCHAR(40),
	league_level_id INTEGER NOT NULL,
	league_system_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX league_uix on leagueSystem(league_id);
ALTER TABLE leagueSystem ADD CONSTRAINT league_pk PRIMARY KEY (league_id);
ALTER TABLE leagueSystem ADD FOREIGN KEY (league_system_id) REFERENCES league_system(league_system_id);
ALTER TABLE leagueSystem ADD FOREIGN KEY (league_level_id) REFERENCES league_level(league_level_id);
--ALTER TABLE league_system ADD FOREIGN KEY (top_league_id) REFERENCES leagueSystem(league_id);

CREATE TABLE match(
	match_id INTEGER NOT NULL,
	league_id INTEGER NOT NULL,
	previous_leg_id INTEGER, -- not NULL on cup matches with two and more leg rounds
	home_team_id INTEGER NOT NULL,
	away_team_id INTEGER NOT NULL,
	play_date DATE NOT NULL,
	stadium_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX match_uix on match(match_id);
ALTER TABLE match ADD CONSTRAINT match_pk PRIMARY KEY (match_id);
ALTER TABLE match ADD FOREIGN KEY (league_id) REFERENCES leagueSystem(league_id);
ALTER TABLE match ADD FOREIGN KEY (home_team_id) REFERENCES team(team_id);
ALTER TABLE match ADD FOREIGN KEY (away_team_id) REFERENCES team(team_id);
ALTER TABLE match ADD FOREIGN KEY (stadium_id) REFERENCES stadium(facil_info_id);
ALTER TABLE match ADD FOREIGN KEY (previous_leg_id) REFERENCES match(match_id);


-- ***************************************** CLUB **********************************************************************************

CREATE TABLE club(
	club_id INTEGER NOT NULL,
	name_short VARCHAR(30),
	name_full VARCHAR(70) NOT NULL,
	-- redundant? nation_id INTEGER NOT NULL,
	league_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX club_uix ON club(club_id);
ALTER TABLE club ADD CONSTRAINT club_pk PRIMARY KEY (club_id);
-- redundant? ALTER TABLE club ADD FOREIGN KEY (nation_id) REFERENCES nation(nation_id);
ALTER TABLE club ADD FOREIGN KEY (league_id) REFERENCES leagueSystem(league_id);

CREATE TABLE team(
	team_id INTEGER NOT NULL,
	team_name VARCHAR(30),
	club_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX team_uix ON team(team_id);
ALTER TABLE team ADD CONSTRAINT team_pk PRIMARY KEY (team_id);
ALTER TABLE team ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

CREATE TABLE team_stats(
	team_id INTEGER NOT NULL,
	wins_in_row SMALLINT NOT NULL,
	lost_in_row SMALLINT NOT NULL,
	no_scoring_matches_in_row SMALLINT NOT NULL,

)
CREATE UNIQUE INDEX team_stats_uix ON team_stats(team_id);
ALTER TABLE team_stats ADD CONSTRAINT team_stats_pk PRIMARY KEY (team_id);
ALTER TABLE team_stats ADD FOREIGN KEY (team_id) REFERENCES team(team_id);

CREATE TABLE club_budget(
	club_id INTEGER NOT NULL,
	transfer_budget BIGINT NOT NULL,
	wage_budget BIGINT NOT NULL,
	research_budget BIGINT NOT NULL, --?
	scouting_budget BIGINT NOT NULL --?
	--TODO
);
CREATE UNIQUE INDEX club_budget_uix on club_budget(club_id);
ALTER TABLE club_budget ADD CONSTRAINT club_budget_pk PRIMARY KEY (club_id);
ALTER TABLE club_budget ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

-- defines enum positions like attacker, defender, keeper etc.
CREATE TABLE player_position(
	player_position_id INTEGER NOT NULL,
	name_key VARCHAR(20),
	--TODO effects rate of different skill on different position?
);
CREATE UNIQUE INDEX player_position_uix on player_position(player_position_id);
ALTER TABLE player_position ADD CONSTRAINT player_position_pk PRIMARY KEY (player_position_id);

-- Proportion of player skill (overall?) value when placed on other position than trained
CREATE TABLE player_position_effect(
	player_position_id INTEGER NOT NULL,
	field_position_id INTEGER NOT NULL,
	affect_value NOT NULL -- percentual value 0-100, 100 on the same position, less on other combinations
)

-- ***************************************** FACILITIES ***************
CREATE TABLE facility_info(
	facility_info_id INTEGER NOT NULL,
	level TINYINT,
	future_level TINYINT,
	max_level TINYINT,
	months_to_future TINYINT,
	monthly_cost INTEGER,
	level_upgrade_cost INTEGER,
	image BLOB
);
CREATE UNIQUE INDEX facility_info_uix ON facility_info(facility_info_id);
ALTER TABLE facility_info ADD CONSTRAINT facility_info_pk PRIMARY KEY (facility_info_id);

CREATE TABLE stadium(
	facil_info_id INTEGER NOT NULL,
	club_id INTEGER NOT NULL,
	name VARCHAR(50) NOT NULL,
	city VARCHAR(50),
	capacity INTEGER NOT NULL
);
CREATE UNIQUE INDEX stadium_uix on stadium(facil_info_id);
ALTER TABLE stadium ADD CONSTRAINT stadium_pk PRIMARY KEY (facil_info_id);
ALTER TABLE stadium ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

CREATE TABLE office(
	facil_info_id INTEGER NOT NULL,
	club_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX office_uix on office(facil_info_id);
ALTER TABLE office ADD CONSTRAINT office_pk PRIMARY KEY (facil_info_id);
ALTER TABLE office ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

CREATE TABLE physio_base(
	facil_info_id INTEGER NOT NULL,
	club_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX physio_base_uix on physio_base(facil_info_id);
ALTER TABLE physio_base ADD CONSTRAINT physio_base_pk PRIMARY KEY (facil_info_id);
ALTER TABLE physio_base ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

CREATE TABLE training_base(
	facil_info_id INTEGER NOT NULL,
	club_id INTEGER NOT NULL
);
CREATE UNIQUE INDEX training_base_uix on training_base(facil_info_id);
ALTER TABLE training_base ADD CONSTRAINT training_base_pk PRIMARY KEY (facil_info_id);
ALTER TABLE training_base ADD FOREIGN KEY (club_id) REFERENCES club(club_id);

-- ***************************************** STAFF ***************

CREATE TABLE contract(
	person_id INTEGER NOT NULL,
	wage INTEGER,
	seasons TINYINT,
	club_id INTEGER NOT NULL
	--TODO start_week or start_date, (end_week or is_historical) for person history?
);
CREATE UNIQUE INDEX contract_uix on contract(person_id);
ALTER TABLE contract ADD CONSTRAINT contract_pk PRIMARY KEY (person_id);
ALTER TABLE contract ADD FOREIGN KEY (club_id) REFERENCES club(club_id);
ALTER TABLE contract ADD FOREIGN KEY (person_id) REFERENCES person(person_id);

CREATE TABLE coach(
	person_id INTEGER NOT NULL,
	--coaching TINYINT NOT NULL,
	--motivation TINYINT NOT NULL,
	--discipline TINYINT NOT NULL
);
CREATE UNIQUE INDEX coach_uix on coach(person_id);
ALTER TABLE coach ADD CONSTRAINT coach_pk PRIMARY KEY (person_id);
ALTER TABLE coach ADD FOREIGN KEY (person_id) REFERENCES person(person_id);

CREATE TABLE manager(
	person_id INTEGER NOT NULL	
);
CREATE UNIQUE INDEX manager_uix on manager(person_id);
ALTER TABLE manager ADD CONSTRAINT manager_pk PRIMARY KEY (person_id);
ALTER TABLE manager ADD FOREIGN KEY (person_id) REFERENCES person(person_id);

CREATE TABLE physio(
	person_id INTEGER NOT NULL,
	--physiotherapy TINYINT NOT NULL
);
CREATE UNIQUE INDEX physio_uix on physio(person_id);
ALTER TABLE physio ADD CONSTRAINT physio_pk PRIMARY KEY (person_id);
ALTER TABLE physio ADD FOREIGN KEY (person_id) REFERENCES person(person_id);

CREATE TABLE scout(
	person_id INTEGER NOT NULL,
	--skill_guess TINYINT NOT NULL,
	--potential_guess TINYINT NOT NULL	
);
CREATE UNIQUE INDEX scout_uix on scout(person_id);
ALTER TABLE scout ADD CONSTRAINT scout_pk PRIMARY KEY (person_id);
ALTER TABLE scout ADD FOREIGN KEY (person_id) REFERENCES person(person_id);


-- ***************************************** PLAYER **********************************************************************************

CREATE TABLE player(
	player_id INTEGER NOT NULL,
	promissed_role_id INTEGER NOT NULL,
	height SMALLINT,
	weight SMALLINT,
	condition TINYINT,
	injury TINYINT, --in weeks
	-- suspensation, match ratings in other table

);
CREATE UNIQUE INDEX player_uix on player(player_id);
ALTER TABLE player ADD CONSTRAINT player_pk PRIMARY KEY (player_id);
ALTER TABLE player ADD FOREIGN KEY (player_id) REFERENCES person(person_id);
ALTER TABLE player ADD FOREIGN KEY (promissed_role_id) REFERENCES player_role(player_role_id);

-- defines enum roles like key player, rotation...
CREATE TABLE player_role(
	player_role_id INTEGER NOT NULL,
	name_key VARCHAR(30) NOT NULL
);
CREATE UNIQUE INDEX player_role_uix ON player_role (player_role_id);
ALTER TABLE player_role ADD CONSTRAINT player_role_pk PRIMARY KEY (player_role_id);

-- defines enum skills for staff like defendSkill, coachingSkill, physioSkill etc.
CREATE TABLE skill_info(
	skill_info_id INTEGER NOT NULL,
	name_key VARCHAR(20) NOT NULL,
	range_from TINYINT NOT NULL,
	range_to TINYINT, NOT_NULL
	--TODO effects rate of different skill on different position?
);
CREATE UNIQUE INDEX skill_info_uix on skill_info(skill_info_id);
ALTER TABLE skill_info ADD CONSTRAINT skill_info_pk PRIMARY KEY (skill_info_id);

CREATE TABLE skill(
	person_id INTEGER NOT NULL,
	skill_info_id INTEGER NOT NULL,
	value TINYINT NOT NULL
);
CREATE UNIQUE INDEX skill_uix on skill(person_id, skill_info_id);
ALTER TABLE skill ADD CONSTRAINT skill_pk PRIMARY KEY (person_id, skill_info_id);
ALTER TABLE skill ADD FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE skill ADD FOREIGN KEY (skill_info_id) REFERENCES skill_info(skill_info_id);

CREATE TABLE skill_change(
	person_id INTEGER NOT NULL,
	skill_info_id INTEGER NOT NULL,
	change_by_value DOUBLE NOT NULL, -- TODO: check precision of DOUBLE
	change_date DATE NOT NULL
)
CREATE UNIQUE INDEX skill_uix on skill(person_id, skill_info_id, change_date);
ALTER TABLE skill_change ADD CONSTRAINT skill_pk PRIMARY KEY (person_id, skill_info_id, change_date);
ALTER TABLE skill_change ADD FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE skill_change ADD FOREIGN KEY (skill_info_id) REFERENCES skill_info(skill_info_id);


-- ***************************************** SEASON **********************************************************************************
CREATE TABLE season(
	season_id INTEGER NOT NULL,
	club_id INTEGER NOT NULL,
	league_id INTEGER NOT NULL,
	-- ? cup_id INTEGER NOT NULL,
	start_year SMALLINT NOT_NULL,
	end_year SMALLINT,
	number SMALLINT NOT NULL,
	league_position TINYINT,
	national_cup_standing VARCHAR(20) -- winner | quarterfinalist | 1. round etc
	european_league_standing VARCHAR(20) -- winner | quarterfinalist | 1. round etc
	european_cup_standing VARCHAR(20) -- winner | quarterfinalist | 1. round etc
);
CREATE UNIQUE INDEX season_uix on season(season_id, club_id);
ALTER TABLE season ADD CONSTRAINT season_pk PRIMARY KEY (season_id, club_id);
ALTER TABLE season ADD FOREIGN KEY (league_id) REFERENCES leagueSystem(league_id);

CREATE TABLE match_stats(
	match_id INTEGER NOT NULL,
	winner_id INTEGER, -- on draw NULL
	man_of_the_match_id INTEGER NOT NULL,
	most_impressive_player_id INTEGER, -- on draw NULL, else best player from losing team
	attendance INTEGER NOT NULL
	-- wheater?
)
CREATE UNIQUE INDEX match_stats_uix on match_stats(match_id);
ALTER TABLE match_stats ADD CONSTRAINT match_stats_pk PRIMARY KEY (match_id);
ALTER TABLE match_stats ADD FOREIGN KEY (man_of_the_match_id) REFERENCES player(player_id);
ALTER TABLE match_stats ADD FOREIGN KEY (most_impressive_player_id) REFERENCES player(player_id);

CREATE TABLE team_match_stats(
	match_id INTEGER NOT NULL,
	team_id INTEGER NOT NULL,
	goals TINYINT NOT NULL,
	possession TINYINT NOT NULL,
	attacks TINYINT NOT NULL,
	dangerous_attacks TINYINT NOT NULL,
	shots TINYINT NOT NULL,
	shots_on_target TINYINT NOT NULL,
	shots_off_target TINYINT NOT NULL,
	corners TINYINT NOT NULL,
	free_kicks TINYINT NOT NULL,
	offsides TINYINT NOT NULL,
	fouls TINYINT NOT NULL,
	yellow_cards TINYINT NOT NULL,
	red_cards TINYINT NOT NULL
)
CREATE UNIQUE INDEX team_match_stats_uix on match(match_id, team_id);
ALTER TABLE team_match_stats ADD CONSTRAINT team_match_stats_pk PRIMARY KEY (match_id, team_id);

CREATE TABLE player_match_stats(
	match_id INTEGER NOT NULL,
	player_id INTEGER NOT NULL,
	rating TINYINT NOT NULL,
	goals TINYINT NOT NULL,
	attacks TINYINT NOT NULL,
	dangerous_attacks TINYINT NOT NULL,
	tackles_successful TINYINT NOT NULL,
	ball_steals TINYINT NOT NULL,
	mistakes TINYINT NOT NULL,
	shots TINYINT NOT NULL,
	shots_on_target TINYINT NOT NULL,
	shots_off_target TINYINT NOT NULL,
	offsides TINYINT NOT NULL,
	fouls TINYINT NOT NULL,
	yellow_cards TINYINT NOT NULL,
	red_cards TINYINT NOT NULL
)
CREATE UNIQUE INDEX player_match_stats_uix on player_match_stats(match_id, player_id);
ALTER TABLE player_match_stats ADD CONSTRAINT player_match_stats_pk PRIMARY KEY (match_id, player_id);
