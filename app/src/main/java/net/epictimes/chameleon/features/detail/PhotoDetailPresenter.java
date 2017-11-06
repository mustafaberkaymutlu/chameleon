package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.data.TweetsRepository;

public class PhotoDetailPresenter implements PhotoDetailContract.Presenter {
    private final TweetsRepository tweetsRepository;
    private PhotoDetailContract.View view;
    private final String tweetId;

    public PhotoDetailPresenter(TweetsRepository tweetsRepository,
                                PhotoDetailContract.View view) {
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
