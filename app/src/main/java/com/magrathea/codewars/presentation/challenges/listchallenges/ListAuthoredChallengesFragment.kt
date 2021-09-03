package com.magrathea.codewars.presentation.challenges.listchallenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.model.User

class ListAuthoredChallengesFragment(private val user: User) : Fragment() {
    companion object {
        fun newInstance(user: User) = ListAuthoredChallengesFragment(user)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_challenges, container, false)
    }
}