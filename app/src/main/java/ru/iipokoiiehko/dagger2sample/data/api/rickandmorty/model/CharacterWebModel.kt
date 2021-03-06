package ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class CharacterWebModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String
)