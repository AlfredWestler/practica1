package com.example.rickandmortyalmanaque.ui


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyalmanaque.data.CharacterRepository
import com.example.rickandmortyalmanaque.data.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MortyModel @Inject constructor(
    private val repository: CharacterRepository
): ViewModel() {

    private val _data = mutableStateOf(emptyList<Character>())
    val data : State<List<Character>> get() = _data

    private val _selected = mutableStateOf<Character?>(null)
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