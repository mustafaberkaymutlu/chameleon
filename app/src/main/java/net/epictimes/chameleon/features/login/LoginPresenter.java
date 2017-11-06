package net.epictimes.chameleon.features.login;

import net.epictimes.chameleon.data.remote.Services;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    private final Services services;

    public LoginPresenter(LoginContract.View view, Services services) {
        this.view = view;
        this.services = services;
    }

    @Override
    public void clickLogin() {

    }

    @Override
    public void dropView() {
        view = null;
    }
}
