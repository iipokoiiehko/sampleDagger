package ru.iipokoiiehko.dagger2sample.data.api.starwars

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model.BaseWebModel
import ru.iipokoiiehko.dagger2sample.data.api.starwars.model.BasePeopleWebModel

interface StarWarsWebApi {

    @GET("people")
    fun getPeople(): Single<BaseWebModel<BasePeopleWebModel>>
}