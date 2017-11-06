package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.TweetsRepository;

public class TweetDetailPresenter implements TweetDetailContract.Presenter {
    private final TweetsRepository tweetsRepository;
    private TweetDetailContract.View view;
    private final String tweetId;

    public TweetDetailPresenter(TweetsRepository tweetsRepository,
                                TweetDetailContract.View view) {
        this.tweetsRepository = tweetsRepository;
        this.tweetId = ""; // TODO fix me
        this.view = view;
    }

    @Override
    public void loadTask() {

    }

    @Override
    public void dropView() {
        view = null;
    }
}
