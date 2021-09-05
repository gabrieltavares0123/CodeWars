package com.magrathea.codewars.presentation.listchallenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.R
import com.magrathea.codewars.model.Challenge
import com.magrathea.codewars.model.ChallengeType

class ListCompletedChallengesFragment(
    private val username: String,
) : Fragment() {
    companion object {
        fun newInstance(username: String) = ListCompletedChallengesFragment(username)
    }

    private val fakeCompletedChallenges = listOf(
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.COMPLETED,
        ),
    )

    private lateinit var rvCompletedChallenges: RecyclerView
    private lateinit var challengesAdapter: ChallengesAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_completed_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvCompletedChallenges = view.findViewById(R.id.rv_authored_challenges)
        challengesAdapter = ChallengesAdapter(fakeCompletedChallenges)
        layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rvCompletedChallenges.layoutManager = layoutManager
        rvCompletedChallenges.adapter = challengesAdapter
    }
}