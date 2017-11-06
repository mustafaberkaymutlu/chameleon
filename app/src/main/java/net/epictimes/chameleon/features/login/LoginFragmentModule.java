package net.epictimes.chameleon.features.login;

import net.epictimes.chameleon.data.remote.Services;
import net.epictimes.chameleon.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginFragmentModule {

    @Provides
    @FragmentScoped
    LoginContract.Presenter providePresenter(LoginFragment loginFragment, Services services) {
        return new LoginPresenter(loginFragment, services);
    }

}
