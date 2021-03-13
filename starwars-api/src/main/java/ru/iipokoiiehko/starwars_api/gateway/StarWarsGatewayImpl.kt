package ru.iipokoiiehko.starwars_api.gateway

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.iipokoiiehko.starwars_api.StarWarsWebApi
import ru.iipokoiiehko.starwars_api.mappers.BasePeopleWebMapper
import ru.iipokoiiehko.main_core.gateways.StarWarsGateway
import ru.iipokoiiehko.main_core.models.BasePeople
import javax.inject.Inject

class StarWarsGatewayImpl @Inject constructor(
    private val api: StarWarsWebApi,
    private val mapper: BasePeopleWebMapper
) : StarWarsGateway {

    override fun getBasePeoples(): Single<List<BasePeople>> {
        return api.getPeople()
            .map { mapper.mapList(it.results) }
            .subscribeOn(Schedulers.io())
    }
}