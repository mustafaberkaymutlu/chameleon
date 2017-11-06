package net.epictimes.chameleon.features.list;

import android.support.annotation.NonNull;

import net.epictimes.chameleon.data.TweetsRepository;
import net.epictimes.chameleon.data.UsersRepository;
import net.epictimes.chameleon.data.model.Tweet;

public class PhotoListPresenter implements PhotoListContract.Presenter {

    private final TweetsRepository tweetsRepository;
    private final UsersRepository usersRepository;
    private PhotoListContract.View view;

    public PhotoListPresenter(PhotoListContract.View view,
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
    public void dropView() {
        view = null;
    }
}
