package ru.iipokoiiehko.dagger2sample.data.api.rickandmorty

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model.BaseWebModel
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model.CharacterWebModel

interface RickAndMortyWebApi {

    @GET("character/")
    fun getCharacter(): Single<BaseWebModel<CharacterWebModel>>
}