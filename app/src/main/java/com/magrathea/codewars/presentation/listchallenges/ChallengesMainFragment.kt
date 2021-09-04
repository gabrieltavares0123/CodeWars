package com.magrathea.codewars.presentation.listchallenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.model.Language
import com.magrathea.codewars.domain.model.Ranks
import com.magrathea.codewars.domain.model.User

class ChallengesMainFragment : Fragment() {
    companion object {
        fun newInstance() = ChallengesMainFragment()
    }

//    private val args by navArgs<ChallengesMainFragmentArgs>()

    private val fakeUser = User(
        userName = "aaaaaaa",
        name = "aaaaaaaa aaaaaaaaa",
        ranks = Ranks(overall = 1209),
        bestLanguage = Language(languageName = "kotlin", rank = 1)
    )
    private lateinit var challengesPageAdapter: ChallengesPageAdapter
    private lateinit var challengerViewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_challenges_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        challengesPageAdapter = ChallengesPageAdapter(requireActivity(), fakeUser.name ?: "aaaaa")
        challengerViewPager = view.findViewById(R.id.vp_user_challenges)
        bottomNavigationView = view.findViewById(R.id.bnv_user_challenges)
        challengerViewPager.adapter = challengesPageAdapter
        challengerViewPager.currentItem = 0

        setupBottomNavigation()
    }


    private fun setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mn_it_authored_challenge -> {
                    challengerViewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.mn_it_completed_challenge -> {
                    challengerViewPager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}