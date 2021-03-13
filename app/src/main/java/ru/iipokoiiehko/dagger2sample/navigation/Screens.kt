package ru.iipokoiiehko.dagger2sample.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.iipokoiiehko.dagger2sample.presentation.root.RootFragment
import ru.iipokoiiehko.rickandmorty_feature.screen.RickAndMortyFragment
import ru.iipokoiiehko.starwars_feature.screen.StarWarsFragment

object Screens {
    fun rootScreen() = FragmentScreen { RootFragment.newInstance() }
    fun rickAndMortyScreen() = FragmentScreen { RickAndMortyFragment.newInstance() }
    fun starWarsScreen() = FragmentScreen { StarWarsFragment.newInstance() }
}