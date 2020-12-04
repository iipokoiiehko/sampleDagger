package ru.iipokoiiehko.dagger2sample

import android.app.Application
import ru.iipokoiiehko.dagger2sample.di.AppComponent
import timber.log.Timber

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {

        val appComponent = AppComponent.Initializer.init()
    }
}