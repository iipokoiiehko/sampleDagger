package ru.iipokoiiehko.rickandmorty_api.gateway

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.iipokoiiehko.rickandmorty_api.RickAndMortyWebApi
import ru.iipokoiiehko.rickandmorty_api.mappers.CharacterWebMapper
import ru.iipokoiiehko.main_core.gateways.RickAndMortyGateway
import ru.iipokoiiehko.main_core.models.Character
import javax.inject.Inject

class RickAndMortyGatewayImpl @Inject constructor(
    private val rickAndMortyWebApi: RickAndMortyWebApi,
    private val characterWebMapper: CharacterWebMapper
) : RickAndMortyGateway {

    override fun getCharacter(): Single<List<Character>> {
        return rickAndMortyWebApi.getCharacter()
            .map { characterWebMapper.mapList(it.results) }
            .subscribeOn(Schedulers.io())
    }
}