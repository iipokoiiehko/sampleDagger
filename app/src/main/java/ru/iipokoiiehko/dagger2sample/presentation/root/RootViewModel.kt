package ru.iipokoiiehko.dagger2sample.presentation.root

import com.github.terrakok.cicerone.Router
import ru.iipokoiiehko.dagger2sample.navigation.Screens
import ru.iipokoiiehko.dagger2sample.presentation.base.BaseViewModel
import javax.inject.Inject

class RootViewModel @Inject constructor(
    private val router: Router
): BaseViewModel() {

    fun toRickAndMorty() {
        router.navigateTo(Screens.rickAndMortyScreen())
    }

    fun toStarWars() {
        router.navigateTo(Screens.starWarsScreen())
    }
}