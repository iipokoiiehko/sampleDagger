package ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.mapper

import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model.CharacterWebModel
import ru.iipokoiiehko.dagger2sample.data.utils.Mapper
import ru.iipokoiiehko.dagger2sample.domain.model.rickandmorty.Character
import javax.inject.Inject

class CharacterWebMapper @Inject constructor() : Mapper<CharacterWebModel, Character>() {

    override fun map(source: CharacterWebModel): Character = with(source) {
        Character(
            id = id,
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender
        )
    }
}