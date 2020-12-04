package ru.iipokoiiehko.dagger2sample.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.iipokoiiehko.dagger2sample.presentation.rickandmorty.RickAndMortyFragment
import ru.iipokoiiehko.dagger2sample.presentation.root.RootFragment
import ru.iipokoiiehko.dagger2sample.presentation.startwars.StarWarsFragment

object Screens {
    fun rootScreen() = FragmentScreen { RootFragment.newInstance() }
    fun rickAndMortyScreen() = FragmentScreen { RickAndMortyFragment.newInstance() }
    fun starWarsScreen() = FragmentScreen { StarWarsFragment.newInstance() }
}