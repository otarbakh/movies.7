package com.example.movies7.api

import com.example.movies7.Models.Mmodelsi.PopularMovie
import retrofit2.http.GET
import retrofit2.http.Query


interface movieAPI {
    @GET("movie/popular")

    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey:String): PopularMovie
}
