package ru.iipokoiiehko.main_core_api.model

import com.google.gson.annotations.SerializedName

data class BaseWebModel<T>(
    @SerializedName("results")
    val results: List<T>
)