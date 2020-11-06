package com.example.socialmediaintegration.di;

import android.app.Application;


import com.example.socialmediaintegration.Activity.MainActivity;
import com.example.socialmediaintegration.util.StartApplication;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/*
 * App module used to inject fragments, services and activities.
 */
@Module(includes = {AndroidInjectionModule.class, RepositoryModule.class, PresenterModule.class})
abstract class AppModule {

    @Binds
    @Singleton
    abstract Application getApplication(StartApplication application);

    @PerActivity
    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();


}
