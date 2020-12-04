package ru.iipokoiiehko.dagger2sample.domain.interactors

import ru.iipokoiiehko.dagger2sample.core.gateway.StarWarsGateway
import javax.inject.Inject

class StartWarsPeopleInteractor @Inject constructor(
    private val startGateway: StarWarsGateway
) {

    fun getBasePeoples() = startGateway.getBasePeoples()
}