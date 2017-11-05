package net.epictimes.owl.features.login;

import net.epictimes.owl.data.api.Services;
import net.epictimes.owl.di.FragmentScoped;

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
