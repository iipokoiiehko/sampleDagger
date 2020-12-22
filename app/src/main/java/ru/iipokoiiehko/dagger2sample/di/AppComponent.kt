package ru.iipokoiiehko.dagger2sample.di

import dagger.Component
import ru.iipokoiiehko.dagger2sample.di.modules.CiceroneModule
import ru.iipokoiiehko.dagger2sample.di.modules.GatewaysModule
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule
import ru.iipokoiiehko.dagger2sample.presentation.MainActivity
import ru.iipokoiiehko.dagger2sample.presentation.rickandmorty.RickAndMortyFragment
import ru.iipokoiiehko.dagger2sample.presentation.root.RootFragment
import ru.iipokoiiehko.dagger2sample.presentation.startwars.StarWarsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        GatewaysModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: RootFragment)
    fun inject(fragment: RickAndMortyFragment)
    fun inject(fragment: StarWarsFragment)

    class Initializer private constructor() {

        companion object {
            fun init(): AppComponent {
                return DaggerAppComponent.builder()
                    .build()
            }
        }
    }
}