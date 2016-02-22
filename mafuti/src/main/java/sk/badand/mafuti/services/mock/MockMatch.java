/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import sk.badand.mafuti.model.common.Weather;
import sk.badand.mafuti.services.PlayableStadium;
import sk.badand.mafuti.services.PlayableTeam;
import sk.badand.mafuti.services.Player;
import sk.badand.mafuti.services.PlayableMatch;

/**
 *
 * @author abadinka
 */
public class MockMatch implements PlayableMatch {
    private static final int TOP_PLAYERS_COUNT = 5;
    
    private PlayableTeam homeTeam = new MockTeam();
    private PlayableTeam awayTeam = new MockTeam();
    private PlayableStadium stadium;

    public MockMatch() {
        this.stadium = homeTeam.getStadium();
    }

    public MockMatch(PlayableTeam homeTeam, PlayableTeam awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = homeTeam.getStadium();
    }
    
    @Override
    public void play() {  
        /**
         * ...
         */
        
        createResult();
    }

    private void createResult() {
    }
    
    @Override
    public String getHomeTeamName() {
        return homeTeam.getNameShort();
    }
    
    @Override
    public String getAwayTeamName() {
        return awayTeam.getNameShort();
    }
    
    @Override
    public List<Player> getHomeTop5Players() {
        return homeTeam.getPlayers().stream()
                .filter(player -> player.isPlaying())
                .sorted(Comparator.comparing(Player::getOverallRating).reversed())
                .limit(TOP_PLAYERS_COUNT)
                .collect(Collectors.toList());                
    }
    
    @Override
    public List<Player> getAwayTop5Players() {
        return homeTeam.getPlayers().stream()
                .filter(player -> player.isPlaying())
                .sorted(Comparator.comparing(Player::getOverallRating).reversed())
                .limit(TOP_PLAYERS_COUNT)
                .collect(Collectors.toList());                
    }
    
    @Override
    public String getStadiumName() {
        return stadium.getName();
    }
    
    @Override
    public String getAttendance() {
        return "44444";
    }
    
    @Override
    public LocalDate getPlayDate() {
        return LocalDate.now();
    }
    
    @Override
    public String getPlayTime() {
        return "18:45";
    }
    
    @Override
    public Weather getWeather() {
        return Weather.CLOUDY;
    }    

    @Override
    public PlayableTeam getManagerTeam() {
        return homeTeam;
    }
}
