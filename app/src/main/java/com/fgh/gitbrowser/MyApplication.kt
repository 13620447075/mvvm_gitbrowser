package com.fgh.gitbrowser

import android.app.Activity
import android.app.Application
import com.fgh.gitbrowser.di.AppInject
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * 1.创建application
 *   引入dagger
 */
class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        AppInject.init(this)
    }

}