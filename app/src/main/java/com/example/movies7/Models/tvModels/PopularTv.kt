package com.example.movies7.Models.tvModels


import com.google.gson.annotations.SerializedName

data class PopularTv(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val result:List<ResultA>)
