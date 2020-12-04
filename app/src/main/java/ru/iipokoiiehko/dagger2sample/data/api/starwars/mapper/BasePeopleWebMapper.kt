package ru.iipokoiiehko.dagger2sample.data.api.starwars.mapper

import ru.iipokoiiehko.dagger2sample.data.api.starwars.model.BasePeopleWebModel
import ru.iipokoiiehko.dagger2sample.data.utils.Mapper
import ru.iipokoiiehko.dagger2sample.domain.model.starwars.BasePeople
import javax.inject.Inject

class BasePeopleWebMapper @Inject constructor() : Mapper<BasePeopleWebModel, BasePeople>() {

    override fun map(source: BasePeopleWebModel): BasePeople = with(source) {
        BasePeople(
            uid = uid,
            name = name,
            url = url
        )
    }
}