package com.magrathea.codewars.data.remote

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    companion object {
        private const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    @Provides
    fun provideCodeWarApi(): CodeWarsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CodeWarsApi::class.java)
    }
}