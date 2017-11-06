package net.epictimes.chameleon.features.timeline;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.model.Tweet;
import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

import java.util.List;

public interface TimelineContract {

    interface View extends BaseView<Presenter> {

        void showTweetDetailUi(String tweetId);

        void showTweets(List<Tweet> tweets);

        void showNoTweets();

        void showLoadingTimelineError();

        void goToLogin();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        /**
         * @param forceUpdate reload data triggering a refresh from source of truth.
         */
        void loadTimeline(boolean forceUpdate);

        void openTweetDetails(@NonNull Tweet requestedTweet);

        void checkUserSessionValidity();

    }

}
