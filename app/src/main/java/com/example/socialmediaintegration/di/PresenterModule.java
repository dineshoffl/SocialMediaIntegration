package com.example.socialmediaintegration.di;


import com.example.socialmediaintegration.Activity.MainScreenPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Module for injecting presenters into the activity.
 */
@Module
abstract class PresenterModule {

    @Binds
    @PerActivity
    abstract MainScreenPresenter providesMainScreenPresenter(MainScreenPresenter presenter);

}
