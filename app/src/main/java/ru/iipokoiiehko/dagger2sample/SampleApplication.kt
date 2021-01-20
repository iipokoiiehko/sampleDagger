package ru.iipokoiiehko.dagger2sample

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.iipokoiiehko.dagger2sample.di.AppComponent
import timber.log.Timber

class SampleApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return AppComponent.Initializer.init()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}