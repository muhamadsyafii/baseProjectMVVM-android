package com.syafii.app

import android.app.Application
import com.syafii.app.infrastructure.di.*
import com.syafii.data.BuildConfig.IS_RELEASE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class AppControler : Application() {
    override fun onCreate() {
        super.onCreate()

        if (!IS_RELEASE) Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@AppControler)

            modules(
                listOf(
                    appModules,
                    mapperModules,
                    persistenceModules,
                    repositoryModules,
                    useCaseModules,
                    viewModelModules
                )
            )
        }
    }
}