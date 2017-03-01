package sk.badand.mafuti.services.inject;

import sk.badand.mafuti.model.Club;

/**
 * Created by abadinka.
 */
public final class UsersClubHolder {
    private final Club usersClub;

    public UsersClubHolder(Club usersClub) {
        this.usersClub = usersClub;
    }

    public Club getClub() {
        return usersClub;
    }
}
