package com.example.rickandmortyalmanaque.di

import com.example.rickandmortyalmanaque.core.RetrofitHelper
import com.example.rickandmortyalmanaque.data.CharacterRepository
import com.example.rickandmortyalmanaque.data.network.ApiService
import com.example.rickandmortyalmanaque.data.network.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideApi(): ApiService = RetrofitHelper.getRetrofit().create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideService(api: ApiService): CharacterService = CharacterService(api)

    @Provides
    @Singleton
    fun provideRepository(service: CharacterService): CharacterRepository = CharacterRepository(service)
}