package com.example.movies7.models.tvModels

data class SrialSS(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)