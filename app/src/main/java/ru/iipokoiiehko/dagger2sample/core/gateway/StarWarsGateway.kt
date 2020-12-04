package ru.iipokoiiehko.dagger2sample.core.gateway

import io.reactivex.rxjava3.core.Single
import ru.iipokoiiehko.dagger2sample.domain.model.starwars.BasePeople

interface StarWarsGateway {

    fun getBasePeoples(): Single<List<BasePeople>>
}