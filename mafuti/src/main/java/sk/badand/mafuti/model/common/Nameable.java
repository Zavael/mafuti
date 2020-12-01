package sk.badand.mafuti.model.common;

import java.io.Serializable;

/**
 * Created by abadinka.
 */
public interface Nameable extends Serializable {
    String firstName();

    String lastName();

    String middleName();

    String getFullName();

    String namePrefix();

    String nameSuffix();

    String nickname();
}
