package ru.iipokoiiehko.dagger2sample.data.api.starwars.model

import com.google.gson.annotations.SerializedName

data class BasePeopleWebModel(
    @SerializedName("uid")
    val uid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)