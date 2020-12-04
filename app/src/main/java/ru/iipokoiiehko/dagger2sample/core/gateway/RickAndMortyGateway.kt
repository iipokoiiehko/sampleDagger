package ru.iipokoiiehko.dagger2sample.core.gateway

import io.reactivex.rxjava3.core.Single
import ru.iipokoiiehko.dagger2sample.domain.model.rickandmorty.Character

interface RickAndMortyGateway {

    fun getCharacter(): Single<List<Character>>
}