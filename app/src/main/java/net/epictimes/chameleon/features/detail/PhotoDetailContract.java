package net.epictimes.chameleon.features.detail;

import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

public interface PhotoDetailContract {

    interface View extends BaseView<Presenter> {

        void showMissingTask();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadTask();

    }

}
