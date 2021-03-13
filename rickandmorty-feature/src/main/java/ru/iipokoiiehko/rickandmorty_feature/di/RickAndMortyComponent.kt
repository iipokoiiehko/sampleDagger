package ru.iipokoiiehko.rickandmorty_feature.di

import dagger.Component
import ru.iipokoiiehko.main_core.ApplicationProvider
import ru.iipokoiiehko.main_core.GatewayProvider
import ru.iipokoiiehko.rickandmorty_feature.screen.RickAndMortyFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        GatewayProvider::class
    ]
)
interface RickAndMortyComponent {

    fun inject(fragment: RickAndMortyFragment)

    class Initializer private constructor() {

        companion object {

            fun init(applicationProvider: ApplicationProvider): RickAndMortyComponent {
                return DaggerRickAndMortyComponent.builder()
                    .gatewayProvider(applicationProvider)
                    .build()
            }
        }
    }
}