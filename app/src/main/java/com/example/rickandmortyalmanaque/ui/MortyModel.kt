package com.example.rickandmortyalmanaque.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyalmanaque.data.CharacterRepository
import com.example.rickandmortyalmanaque.data.model.Character
import kotlinx.coroutines.launch

class MortyModel : ViewModel() {

    private val repository = CharacterRepository( )

    val dataPerson = MutableLiveData<List<Character>>()

    fun detail(){
        viewModelScope.launch {
            dataPerson.postValue(repository.getAllCharacters())
        }
    }





}