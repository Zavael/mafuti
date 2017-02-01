package sk.badand.mafuti.model.common;

import java.util.ResourceBundle;

/**
 * Created by zavael on 6.11.2016.
 */
public class MediaStory {
    public final String titleKey;
    public final String messageKey;

    public MediaStory(String key) {
        this.titleKey = key + ".title";
        this.messageKey = key + ".message";
    }
}
