package ru.iipokoiiehko.dagger2sample.domain.interactors

import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import java.lang.IllegalArgumentException
import javax.inject.Inject

class RickAndMortyInteractor @Inject constructor(
    private val rickAndMortyGateway: RickAndMortyGateway
) {

    fun getCharacter() = rickAndMortyGateway.getCharacter()
}