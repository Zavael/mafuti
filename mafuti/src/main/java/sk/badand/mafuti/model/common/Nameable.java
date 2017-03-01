package sk.badand.mafuti.model.common;

/**
 * Created by abadinka.
 */
public interface Nameable {
    String firstName();

    String lastName();

    String middleName();

    String getFullName();

    String namePrefix();

    String nameSuffix();

    String nickname();
}
