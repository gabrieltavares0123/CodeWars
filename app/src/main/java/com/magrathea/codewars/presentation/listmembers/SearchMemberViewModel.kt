package com.magrathea.codewars.presentation.listmembers

import androidx.lifecycle.*
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.domain.repository.UserRepository
import com.magrathea.codewars.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchMemberViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val sortMembersBy = MutableLiveData<SortType>()
    private val searchFor = MutableLiveData<String>()

    fun searchFor(query: String?) {
        query?.let { searchFor.value = it }
    }

    fun sortMembersBy(sortType: SortType) {
        sortMembersBy.value = sortType
    }

    val searchForEmission = searchFor.switchMap {
        liveData {
            emit(Resource.Loading)
            emitSource(userRepository.findUserByUserName(it))
        }
    }

    val sortMembersByEmission = sortMembersBy.switchMap {
        liveData {
            emit(Resource.Loading)
            emitSource(userRepository.findLastFiveUsersBySortType(it))
        }
    }

    val isLoading = MediatorLiveData<Boolean>().also { mediator ->
        mediator.addSource(searchForEmission) {
            mediator.value = it.isLoading
        }

        mediator.addSource(sortMembersByEmission) {
            mediator.value = it.isLoading
        }
    }

    val hasDataToShow = MediatorLiveData<Boolean>().also { mediator ->
        mediator.addSource(searchForEmission) {
            mediator.value = it.isSuccess && it.toData()?.isEmpty() == true
        }

        mediator.addSource(sortMembersByEmission) {
            mediator.value = it.isSuccess && it.toData()?.isEmpty() == true
        }
    }
}