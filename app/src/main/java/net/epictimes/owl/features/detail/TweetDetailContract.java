package net.epictimes.owl.features.detail;

import net.epictimes.owl.features.BasePresenter;
import net.epictimes.owl.features.BaseView;

public interface TweetDetailContract {

    interface View extends BaseView<Presenter> {

        void showMissingTask();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadTask();

    }

}
