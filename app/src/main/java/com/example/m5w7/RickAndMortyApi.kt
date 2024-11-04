package com.example.m5w7

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterResponse>
}