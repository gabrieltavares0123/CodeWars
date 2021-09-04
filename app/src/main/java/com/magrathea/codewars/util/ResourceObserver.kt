package com.magrathea.codewars.util

import androidx.lifecycle.Observer

class ResourceObserver<T : Any>(private val callback: (T) -> Unit) : Observer<Resource<T>> {
    override fun onChanged(t: Resource<T>) {
        if (t.isSuccess) {
            t.toData()?.let(callback::invoke)
        }
    }
}