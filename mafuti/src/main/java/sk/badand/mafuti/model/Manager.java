package sk.badand.mafuti.model;

import sk.badand.mafuti.model.common.PersonType;

/**
 * Created by abadinka.
 */
public interface Manager extends Staff {

    @Override
    default PersonType personType() {
        return PersonType.MANAGER;
    }
}
