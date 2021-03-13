package ru.iipokoiiehko.dagger2sample

import android.app.Application
import ru.iipokoiiehko.dagger2sample.di.AppComponent
import ru.iipokoiiehko.main_core.App
import ru.iipokoiiehko.main_core.ApplicationProvider
import timber.log.Timber

class SampleApplication : Application(), App {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    private val appComponent: AppComponent by lazy { AppComponent.Initializer.init() }

    override fun getAppComponent(): ApplicationProvider = appComponent

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}