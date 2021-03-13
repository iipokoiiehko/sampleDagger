package ru.iipokoiiehko.starwars_api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.iipokoiiehko.main_core_api.model.BaseWebModel
import ru.iipokoiiehko.starwars_api.models.BasePeopleWebModel

interface StarWarsWebApi {

    @GET("people")
    fun getPeople(): Single<BaseWebModel<BasePeopleWebModel>>
}