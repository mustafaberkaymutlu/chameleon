package net.epictimes.owl.features.login;

import net.epictimes.owl.features.BasePresenter;
import net.epictimes.owl.features.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void openLoginPage();

    }

    interface Presenter extends BasePresenter {

        void clickLogin();

    }
}
