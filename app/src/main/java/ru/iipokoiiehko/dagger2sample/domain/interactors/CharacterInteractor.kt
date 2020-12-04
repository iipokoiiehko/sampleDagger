package ru.iipokoiiehko.dagger2sample.domain.interactors

import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
    private val rickAndMortyGateway: RickAndMortyGateway
) {

    fun getCharacter() = rickAndMortyGateway.getCharacter()
}