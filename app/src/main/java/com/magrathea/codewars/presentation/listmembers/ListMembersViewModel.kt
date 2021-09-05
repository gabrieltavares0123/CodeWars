package com.magrathea.codewars.presentation.listmembers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.domain.repository.UserRepository
import com.magrathea.codewars.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListMembersViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val searchQuery = MutableLiveData<String>()
    private val sortMembers = MutableLiveData<SortType>()


    fun searchQuery(query: String?) {
        query.let { searchQuery.value = it }
    }

    fun sortMembers(sortType: SortType) {
        sortMembers.value = sortType
    }

    val sortedMembers = sortMembers.switchMap { sortType ->
        liveData {
            emit(Resource.Loading)
            emitSource(userRepository.findAllBySortType(sortType))
        }
    }
}