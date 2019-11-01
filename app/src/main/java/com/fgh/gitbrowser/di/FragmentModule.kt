package com.fgh.gitbrowser.di

import com.fgh.gitbrowser.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * fragment的module,因为木有，所以不用写
 */
@Suppress("unused")
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment

}
//@Suppress("unused")
//@Module
//abstract class FragmentBuildersModule {
//
//
//    @ContributesAndroidInjector
//    abstract fun contributeUserFragment(): UserFragment
//
//
//}