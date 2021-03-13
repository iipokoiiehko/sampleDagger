package ru.iipokoiiehko.main_core.gateways

import io.reactivex.rxjava3.core.Single
import ru.iipokoiiehko.main_core.models.BasePeople

interface StarWarsGateway {

    fun getBasePeoples(): Single<List<BasePeople>>
}