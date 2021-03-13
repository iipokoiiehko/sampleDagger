package ru.iipokoiiehko.starwars_feature.di

import dagger.Component
import ru.iipokoiiehko.main_core.ApplicationProvider
import ru.iipokoiiehko.starwars_feature.screen.StarWarsFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ApplicationProvider::class
    ]
)
interface StarWarsComponent {

    fun inject(fragment: StarWarsFragment)

    class Initializer private constructor() {

        companion object {

            fun init(applicationProvider: ApplicationProvider): StarWarsComponent {
                return DaggerStarWarsComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}