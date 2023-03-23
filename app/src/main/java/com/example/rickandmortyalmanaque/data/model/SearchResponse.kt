package com.example.rickandmortyalmanaque.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (
	@SerializedName("info") val info : Info,
	@SerializedName("results") val results : List<Character>
)