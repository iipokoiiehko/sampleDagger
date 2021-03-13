package ru.iipokoiiehko.main_core.gateways

import io.reactivex.rxjava3.core.Single
import ru.iipokoiiehko.main_core.models.Character

interface RickAndMortyGateway {

    fun getCharacter(): Single<List<Character>>
}