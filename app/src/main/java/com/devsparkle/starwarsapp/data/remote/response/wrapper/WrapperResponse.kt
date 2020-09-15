package com.devsparkle.starwarsapp.data.remote.response.wrapper

import com.google.gson.annotations.SerializedName


data class WrapperResponse<T>(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<T>
)