package net.epictimes.chameleon.features.login;

import net.epictimes.chameleon.features.BasePresenter;
import net.epictimes.chameleon.features.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void openLoginPage();

    }

    interface Presenter extends BasePresenter {

        void clickLogin();

    }
}
