package com.magrathea.codewars.util

sealed class Resource<out T: Any> {
    data class Success<out T: Any>(val data: T): Resource<T>()
    data class Error(val exception: Throwable): Resource<Nothing>()
    object Loading: Resource<Nothing>()

    fun toData(): T? = if(this is Success) this.data else null
    val isSuccess get() = this is Success
    val isLoading get() = this is Loading
    val isError get() = this is java.lang.Error
}