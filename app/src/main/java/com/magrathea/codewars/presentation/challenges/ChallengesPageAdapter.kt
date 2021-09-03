package com.magrathea.codewars.presentation.challenges

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.magrathea.codewars.domain.model.User
import com.magrathea.codewars.presentation.challenges.listchallenges.ListAuthoredChallengesFragment
import com.magrathea.codewars.presentation.challenges.listchallenges.ListCompletedChallengesFragment

class ChallengesPageAdapter(
    fragmentActivity: FragmentActivity,
    user: User,
) : FragmentStateAdapter(fragmentActivity) {
    private val fragmentsList = listOf(
        ListAuthoredChallengesFragment.newInstance(user),
        ListCompletedChallengesFragment.newInstance(user),
    )

    override fun getItemCount(): Int = fragmentsList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }
}