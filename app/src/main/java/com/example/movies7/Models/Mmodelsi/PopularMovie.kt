package com.example.movies7.Models.Mmodelsi


import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query



data class PopularMovie (
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results:List<Resultati>

        )
