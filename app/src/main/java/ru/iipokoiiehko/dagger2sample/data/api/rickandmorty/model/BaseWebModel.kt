package ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class BaseWebModel<T>(
    @SerializedName("results")
    val results: List<T>
)