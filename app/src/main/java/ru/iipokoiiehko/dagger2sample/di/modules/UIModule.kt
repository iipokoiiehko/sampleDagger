package ru.iipokoiiehko.dagger2sample.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.iipokoiiehko.dagger2sample.presentation.MainActivity
import ru.iipokoiiehko.dagger2sample.presentation.rickandmorty.RickAndMortyFragment
import ru.iipokoiiehko.dagger2sample.presentation.root.RootFragment
import ru.iipokoiiehko.dagger2sample.presentation.startwars.StarWarsFragment

@Module
abstract class UIModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesRickAndMortyFragment(): RickAndMortyFragment

    @ContributesAndroidInjector
    abstract fun contributesStarWarsFragment(): StarWarsFragment

    @ContributesAndroidInjector
    abstract fun contributesRootFragment(): RootFragment
}