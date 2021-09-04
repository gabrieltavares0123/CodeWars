package com.magrathea.codewars.presentation.listchallenges

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.magrathea.codewars.domain.model.User

class ChallengesPageAdapter(
    fragmentActivity: FragmentActivity,
    username: String
) : FragmentStateAdapter(fragmentActivity) {
    private val fragmentsList = listOf(
        ListAuthoredChallengesFragment.newInstance(username),
        ListCompletedChallengesFragment.newInstance(username),
    )

    override fun getItemCount(): Int = fragmentsList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }
}