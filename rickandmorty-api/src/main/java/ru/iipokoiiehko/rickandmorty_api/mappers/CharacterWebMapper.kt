package ru.iipokoiiehko.rickandmorty_api.mappers

import ru.iipokoiiehko.main_core_api.Mapper
import ru.iipokoiiehko.rickandmorty_api.models.CharacterWebModel
import ru.iipokoiiehko.main_core.models.Character
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