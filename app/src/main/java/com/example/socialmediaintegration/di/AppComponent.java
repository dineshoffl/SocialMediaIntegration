package com.example.socialmediaintegration.di;

import com.example.socialmediaintegration.util.StartApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<StartApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<StartApplication> {

    }
}
