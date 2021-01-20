package ru.iipokoiiehko.dagger2sample.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.iipokoiiehko.dagger2sample.SampleApplication
import ru.iipokoiiehko.dagger2sample.di.modules.CiceroneModule
import ru.iipokoiiehko.dagger2sample.di.modules.GatewaysModule
import ru.iipokoiiehko.dagger2sample.di.modules.UIModule
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        CiceroneModule::class,
        GatewaysModule::class,
        NetworkModule::class,
        UIModule::class
    ]
)
interface AppComponent : AndroidInjector<SampleApplication> {

    class Initializer private constructor() {

        companion object {
            fun init(): AppComponent {
                return DaggerAppComponent.builder()
                    .build()
            }
        }
    }
}