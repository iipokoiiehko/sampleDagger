package ru.iipokoiiehko.starwars_api.mappers

import ru.iipokoiiehko.main_core_api.Mapper
import ru.iipokoiiehko.starwars_api.models.BasePeopleWebModel
import ru.iipokoiiehko.main_core.models.BasePeople
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