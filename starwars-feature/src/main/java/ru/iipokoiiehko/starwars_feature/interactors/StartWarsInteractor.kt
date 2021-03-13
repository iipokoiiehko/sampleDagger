package ru.iipokoiiehko.starwars_feature.interactors

import ru.iipokoiiehko.main_core.gateways.StarWarsGateway
import javax.inject.Inject

class StartWarsInteractor @Inject constructor(
    private val startGateway: StarWarsGateway
) {

    fun getBasePeoples() = startGateway.getBasePeoples()
}