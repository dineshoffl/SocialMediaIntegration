package com.example.socialmediaintegration.util

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class StartApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        // Dagger AppComponent for injection
        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity?>? {
        return mAndroidInjector
    }

}