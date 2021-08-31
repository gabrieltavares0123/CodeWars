package com.magrathea.codewars.data

import com.magrathea.codewars.model.remote.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeWarsApi {
    @GET(value = "/users/{user}")
    fun findUserByName(@Path(value = "user") user: String): Call<User>
}
