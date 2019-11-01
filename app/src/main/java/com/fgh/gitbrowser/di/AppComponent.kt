package com.fgh.gitbrowser.di

import android.app.Application
import com.fgh.gitbrowser.MyApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * module容器？
 */

@Singleton
@Component(
    modules = [AppModule::class,
        MainActivityModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)

}
