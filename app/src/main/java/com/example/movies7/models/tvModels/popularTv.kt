package com.example.movies7.models.tvModels
import retrofit2.http.GET
import kotlin.Result

import com.google.gson.annotations.SerializedName

data class popularTv(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results:List<com.example.movies7.models.mModels.Result>)
