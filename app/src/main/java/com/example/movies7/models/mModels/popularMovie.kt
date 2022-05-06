package com.example.movies7.Models.MovieModels

import com.example.movies7.models.mModels.Result
import com.google.gson.annotations.SerializedName

data class popularMovie(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results:List<Result>
)
