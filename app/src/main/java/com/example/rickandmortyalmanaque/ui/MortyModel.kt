package com.example.rickandmortyalmanaque.ui


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyalmanaque.data.CharacterRepository
import com.example.rickandmortyalmanaque.data.model.Character
import kotlinx.coroutines.launch

class MortyModel : ViewModel() {

    private val repository = CharacterRepository( )

    val dataPerson = MutableLiveData<List<Character>>()
    val _data = mutableStateOf(emptyList<Character>())
    val data : State<List<Character>> get() = _data

    val _selected = mutableStateOf<Character?>(null)
    val selected : State<Character?> get() = _selected
    fun detail(){
        viewModelScope.launch {
            //dataPerson.postValue(repository.getAllCharacters())
            _data.value = repository.getAllCharacters()
        }
    }

    fun setCharacter(selected: com.example.rickandmortyalmanaque.data.model.Character){
        _selected.value = selected
    }



}