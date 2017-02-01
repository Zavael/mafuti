package sk.badand.mafuti.ui.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.MediaStory;

import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class ListViewMediaNewsTitleFactory implements Callback<ListView<MediaStory>, ListCell<MediaStory>> {
    private ResourceBundle bundle;

    public ListViewMediaNewsTitleFactory(ResourceBundle rb) {

        bundle = rb;
    }

    @Override
    public ListCell<MediaStory> call(ListView<MediaStory> mediaStoryListView) {
        return new ListCell<MediaStory>() {
            @Override
            protected void updateItem(MediaStory item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(bundle.getString(item.titleKey));
                }
            }
        };
    }
}
