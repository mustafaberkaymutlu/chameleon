package net.epictimes.chameleon.features.login;

import net.epictimes.chameleon.di.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = LoginFragmentModule.class)
    abstract LoginFragment contributeLoginFragmentInjector();

}
