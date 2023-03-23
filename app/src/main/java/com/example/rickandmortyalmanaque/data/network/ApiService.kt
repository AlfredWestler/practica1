package com.example.rickandmortyalmanaque.data.network

import com.example.rickandmortyalmanaque.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters():Response<SearchResponse>

    @GET
    suspend fun getPaginationCharacters(@Url url:String):Response<SearchResponse>
}