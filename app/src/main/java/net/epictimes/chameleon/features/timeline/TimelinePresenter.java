package net.epictimes.chameleon.features.timeline;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.data.UsersRepository;
import net.epictimes.chameleon.data.model.Tweet;

public class TimelinePresenter implements TimelineContract.Presenter {

    private final TweetsRepository tweetsRepository;
    private final UsersRepository usersRepository;
    private TimelineContract.View view;

    public TimelinePresenter(TimelineContract.View view,
                             TweetsRepository tweetsRepository,
                             UsersRepository usersRepository) {
        this.tweetsRepository = tweetsRepository;
        this.view = view;
        this.usersRepository = usersRepository;
    }

    @Override
    public void loadTimeline(boolean forceUpdate) {

    }

    @Override
    public void openTweetDetails(@NonNull Tweet requestedTweet) {

    }

    @Override
    public void checkUserSessionValidity() {
        usersRepository.isUserLoggedIn(isUserLoggedIn -> {
            if (!isUserLoggedIn && view != null) {
                view.goToLogin();
            }
        });
    }

    @Override
    public void dropView() {
        view = null;
    }
}
