package com.magrathea.codewars.presentation.listchallenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.model.User

class ListCompletedChallengesFragment(private val user: User) : Fragment() {
    companion object {
        fun newInstance(user: User) = ListCompletedChallengesFragment(user)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_challenges, container, false)
    }
}