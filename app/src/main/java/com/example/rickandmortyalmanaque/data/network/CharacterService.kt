package com.example.rickandmortyalmanaque.data.network

import com.example.rickandmortyalmanaque.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {

    private val retrofit = RetrofitHelper.getRetrofit()
    val allCharactersList= mutableListOf<com.example.rickandmortyalmanaque.data.model.Character>()
    val charactersList= mutableListOf<com.example.rickandmortyalmanaque.data.model.Character>()
    private val BASE_URL = "https://rickandmortyapi.com/api/"

    suspend fun getAllCharacters(): List<com.example.rickandmortyalmanaque.data.model.Character>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiService::class.java).getAllCharacters()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    allCharactersList.addAll(body.results)
                }
                if (!body?.info?.next.isNullOrEmpty()) {
                    body?.info?.next?.let {
                        getPaginationCharacters(it.replace(BASE_URL, ""))
                    }
                }
                allCharactersList
            }else{
                emptyList()
            }
        }
    }

    suspend fun getPaginationCharacters(url: String){
        val resPage =retrofit.create(ApiService::class.java).getPaginationCharacters(url)
        resPage.body()?.let { it1 ->
            charactersList.clear()
            charactersList.addAll(it1.results)
            allCharactersList.addAll(charactersList)
            if (!it1.info.next.isNullOrEmpty()){
                it1.info.next.let { getPaginationCharacters(it.replace(BASE_URL, "")) }
            }
        }
    }
}