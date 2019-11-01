package com.fgh.gitbrowser.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fgh.gitbrowser.user.UserViewModel
import com.fgh.gitbrowser.viewmodel.GithubViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * ViewModel的module
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    //需要写每个model
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: GithubViewModelFactory): ViewModelProvider.Factory

}

