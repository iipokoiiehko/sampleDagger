package ru.iipokoiiehko.dagger2sample.presentation

import com.github.terrakok.cicerone.Router
import ru.iipokoiiehko.dagger2sample.navigation.Screens
import ru.iipokoiiehko.dagger2sample.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
) : BaseViewModel() {

    fun toRoot() {
        router.newRootChain(Screens.rootScreen())
    }
}