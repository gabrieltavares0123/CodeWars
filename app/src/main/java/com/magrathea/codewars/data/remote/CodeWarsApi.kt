package com.magrathea.codewars.data.remote

import com.magrathea.codewars.model.AuthoredChallenge
import com.magrathea.codewars.model.ChallengeResponse
import com.magrathea.codewars.model.CompletedChallenge
import com.magrathea.codewars.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {
    @GET(value = "/users/{user}")
    fun findUserByUserName(@Path(value = "user") username: String): Call<User>

    @GET(value = "users/{username}/code-challenges/completed")
    fun findCompletedChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Call<ChallengeResponse<CompletedChallenge>>

    @GET(value = "users/{username}/code-challenges/authored")
    fun findAuthoredChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Call<ChallengeResponse<AuthoredChallenge>>
}
