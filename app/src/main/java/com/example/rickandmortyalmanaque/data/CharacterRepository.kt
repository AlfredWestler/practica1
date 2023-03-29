package com.example.rickandmortyalmanaque.data

import com.example.rickandmortyalmanaque.data.model.CharacterProvider
import com.example.rickandmortyalmanaque.data.network.CharacterService
import javax.inject.Inject


class CharacterRepository @Inject constructor(
    private val service: CharacterService
) {

    suspend fun getAllCharacters(): List<com.example.rickandmortyalmanaque.data.model.Character>{
        val response = service.getAllCharacters()
        CharacterProvider.characters = response
        return response
    }
}