package com.example.socialmediaintegration.util

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class StartApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    var mAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    @Inject
    var mFragmentInjector: DispatchingAndroidInjector<Fragment>? = null


    override fun onCreate() {
        super.onCreate()
        // Dagger AppComponent for injection
        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity?>? {
        return mAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment?>? {
        return mFragmentInjector
    }
}