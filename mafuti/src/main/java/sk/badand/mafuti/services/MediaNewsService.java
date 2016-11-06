package sk.badand.mafuti.services;

import sk.badand.mafuti.model.common.MediaStory;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zavael on 6.11.2016.
 */
public class MediaNewsService {

    private Collection<MediaStory> news;

    public MediaNewsService() {
        this.news = Stream.of(
                new MediaStory("New hot transfer ongoing"),
                new MediaStory("Biggest win in premier league"),
                new MediaStory("Club punished for transfer cheat"),
                new MediaStory("Foreign expert shared best training methods"),
                new MediaStory("Club went bankrupt"),
                new MediaStory("Team of the week announced"),
                new MediaStory("Last league round evaluation"))
                .collect(Collectors.toList());
    }

    public Collection<MediaStory> getNews() {
        return news;
    }
}
