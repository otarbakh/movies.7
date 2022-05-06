package com.example.movies7.models.mModels

data class MoviessJsona(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)