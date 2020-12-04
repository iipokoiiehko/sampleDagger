package ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.gateway

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.RickAndMortyWebApi
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.mapper.CharacterWebMapper
import ru.iipokoiiehko.dagger2sample.domain.model.rickandmorty.Character
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