package com.magrathea.codewars.data.remote

import com.magrathea.codewars.data.remote.service.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    companion object {
        private const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    @Provides
    fun provideInterceptorClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideCodeWarApi(okHttpClient: OkHttpClient): CodeWarsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CodeWarsApi::class.java)
    }

    @Provides
    fun provideUserService(codeWarsApi: CodeWarsApi): UserService {
        return UserServiceImpl(codeWarsApi)
    }

    @Provides
    fun provideAuthoredChallengeService(codeWarsApi: CodeWarsApi): AuthoredChallengeService {
        return AuthoredChallengeServiceImpl(codeWarsApi)
    }

    @Provides
    fun provideCompletedChallengeService(codeWarsApi: CodeWarsApi): CompletedChallengeService {
        return CompletedChallengeServiceImpl(codeWarsApi)
    }
}