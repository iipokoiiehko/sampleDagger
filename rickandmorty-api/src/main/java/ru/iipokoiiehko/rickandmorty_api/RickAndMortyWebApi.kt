package ru.iipokoiiehko.rickandmorty_api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.iipokoiiehko.main_core_api.model.BaseWebModel
import ru.iipokoiiehko.rickandmorty_api.models.CharacterWebModel

interface RickAndMortyWebApi {

    @GET("character/")
    fun getCharacter(): Single<BaseWebModel<CharacterWebModel>>
}