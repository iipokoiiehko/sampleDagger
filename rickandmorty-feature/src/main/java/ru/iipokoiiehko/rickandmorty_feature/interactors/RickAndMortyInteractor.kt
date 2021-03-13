package ru.iipokoiiehko.rickandmorty_feature.interactors

import ru.iipokoiiehko.main_core.gateways.RickAndMortyGateway
import javax.inject.Inject

class RickAndMortyInteractor @Inject constructor(
    private val rickAndMortyGateway: RickAndMortyGateway
) {

    fun getCharacter() = rickAndMortyGateway.getCharacter()
}