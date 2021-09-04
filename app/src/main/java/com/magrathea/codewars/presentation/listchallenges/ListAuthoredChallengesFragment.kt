package com.magrathea.codewars.presentation.listchallenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.model.AuthoredChallenge
import com.magrathea.codewars.domain.model.Challenge
import com.magrathea.codewars.domain.model.ChallengeType

class ListAuthoredChallengesFragment(
    private val username: String
) : Fragment() {
    companion object {
        fun newInstance(username: String) = ListAuthoredChallengesFragment(username)
    }

    private val fakeAuthoredChallenges = listOf(
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
        Challenge(
            id = "1",
            name = "aaaaaaaaaaaa",
            type = ChallengeType.AUTHORED,
        ),
    )

    private lateinit var rvAuthoredChallenges: RecyclerView
    private lateinit var challengesAdapter: ChallengesAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_authored_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvAuthoredChallenges = view.findViewById(R.id.rv_authored_challenges)
        challengesAdapter = ChallengesAdapter(fakeAuthoredChallenges)
        layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rvAuthoredChallenges.layoutManager = layoutManager
        rvAuthoredChallenges.adapter = challengesAdapter
    }
}