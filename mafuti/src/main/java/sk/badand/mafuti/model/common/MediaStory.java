package sk.badand.mafuti.model.common;

import java.io.Serializable;

/**
 * Created by zavael on 6.11.2016.
 */
public class MediaStory implements Serializable {
    private static final long serialVersionUID = -1672253687074049864L;
    public final String titleKey;
    public final String messageKey;

    public MediaStory(String key) {
        this.titleKey = key + ".title";
        this.messageKey = key + ".message";
    }
}
