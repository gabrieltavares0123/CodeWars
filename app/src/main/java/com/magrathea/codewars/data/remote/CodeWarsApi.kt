package com.magrathea.codewars.data.remote

import com.magrathea.codewars.data.remote.entity.AuthoredChallengeDto
import com.magrathea.codewars.data.remote.entity.CompletedChallengeDto
import com.magrathea.codewars.data.remote.entity.UserDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {
    @GET(value = "/users/{user}")
    suspend fun findUserByUserName(@Path(value = "user") user: String): Flow<UserDto>

    @GET(value = "users/{username}/code-challenges/completed")
    suspend fun findCompletedChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Flow<CompletedChallengeDto>

    @GET(value = "users/{username}/code-challenges/authored")
    suspend fun findAuthoredChallengesByUser(
        @Path(value = "username") username: String,
        @Query(value = "page") page: Int,
    ): Flow<AuthoredChallengeDto>
}
