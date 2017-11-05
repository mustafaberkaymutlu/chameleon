package net.epictimes.owl.features.timeline;

import android.support.annotation.NonNull;

import net.epictimes.owl.data.model.Tweet;
import net.epictimes.owl.features.BasePresenter;
import net.epictimes.owl.features.BaseView;

import java.util.List;

public interface TimelineContract {

    interface View extends BaseView<Presenter> {

        void showTweetDetailUi(String tweetId);

        void showTweets(List<Tweet> tweets);

        void showNoTweets();

        void showLoadingTimelineError();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        /**
         * @param forceUpdate reload data triggering a refresh from source of truth.
         */
        void loadTimeline(boolean forceUpdate);

        void openTweetDetails(@NonNull Tweet requestedTweet);


    }

}
