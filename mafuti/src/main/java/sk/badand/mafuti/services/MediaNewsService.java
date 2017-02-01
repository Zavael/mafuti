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
                new MediaStory("transfer.new.big"),
                new MediaStory("match.result.biggest"),
                new MediaStory("transfer.fraud"),
                new MediaStory("tips.training.1"),
                new MediaStory("club.bankrupt"),
                new MediaStory("league.announcement.tow"),
                new MediaStory("league.round.eval"))
                .collect(Collectors.toList());
    }

    public Collection<MediaStory> getNews() {
        return news;
    }
}
