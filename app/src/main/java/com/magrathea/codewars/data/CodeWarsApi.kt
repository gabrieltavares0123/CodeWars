package com.magrathea.codewars.data

import com.magrathea.codewars.data.entity.AuthoredChallenge
import com.magrathea.codewars.data.entity.CompletedChallenge
import com.magrathea.codewars.data.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {
    @GET(value = "/users/{user}")
    fun findUserByName(@Path(value = "user") user: String): Call<NetworkResult<User>>

    @GET(value = "users/{username}/code-challenges/completed")
    fun findCompletedChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Call<NetworkResult<CompletedChallenge>>

    @GET(value = "users/{username}/code-challenges/authored")
    fun findAuthoredChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Call<NetworkResult<AuthoredChallenge>>
}
