package ru.iipokoiiehko.dagger2sample.data.api.starwars.gateway

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.iipokoiiehko.dagger2sample.core.gateway.StarWarsGateway
import ru.iipokoiiehko.dagger2sample.data.api.starwars.StarWarsWebApi
import ru.iipokoiiehko.dagger2sample.data.api.starwars.mapper.BasePeopleWebMapper
import ru.iipokoiiehko.dagger2sample.domain.model.starwars.BasePeople
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