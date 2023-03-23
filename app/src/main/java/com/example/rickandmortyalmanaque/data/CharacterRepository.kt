package com.example.rickandmortyalmanaque.data

import com.example.rickandmortyalmanaque.data.model.CharacterProvider
import com.example.rickandmortyalmanaque.data.network.CharacterService


class CharacterRepository {

    private val api = CharacterService()

    suspend fun getAllCharacters(): List<com.example.rickandmortyalmanaque.data.model.Character>{
        val response = api.getAllCharacters()
        CharacterProvider.characters = response
        return response
    }
}