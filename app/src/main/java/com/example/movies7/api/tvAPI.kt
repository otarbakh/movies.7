package com.example.movies7.api



import com.example.movies7.Models.tvModels.PopularTv
import retrofit2.http.GET
import retrofit2.http.Query

interface tvAPI {
    @GET("tv/popular")

    suspend fun getPopularTv(
        @Query("api_key")
        apiKey:String): PopularTv
}