package com.fgh.gitbrowser.di

import com.fgh.gitbrowser.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * activity 的module
 */
@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contribuiteMainActivity(): MainActivity


}