package com.magrathea.codewars.presentation.listmembers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.model.Language
import com.magrathea.codewars.domain.model.Ranks
import com.magrathea.codewars.domain.model.User

class ListMembersFragment : Fragment() {
    private val fakeData = listOf(
        User(
            userName = "aaaaaaa",
            name = "aaaaaaaa aaaaaaaaa",
            ranks = Ranks(overall = 1209),
            bestLanguage = Language(languageName = "kotlin", rank = 1)
        ),
        User(
            userName = "bbbbbbbbbb",
            name = "bb bbbbbbbb",
            ranks = Ranks(overall = 123),
            bestLanguage = Language(languageName = "javascript", rank = 11111111)
        ),
        User(
            userName = "bbbbbbbbbb",
            name = "bb bbbbbbbb",
            ranks = Ranks(overall = 123),
            bestLanguage = Language(languageName = "javascript", rank = 11111111)
        ),
        User(
            userName = "bbbbbbbbbb",
            name = "bb bbbbbbbb",
            ranks = Ranks(overall = 123),
            bestLanguage = Language(languageName = "javascript", rank = 11111111)
        ),
        User(
            userName = "bbbbbbbbbb",
            name = "bb bbbbbbbb",
            ranks = Ranks(overall = 123),
            bestLanguage = Language(languageName = "javascript", rank = 11111111)
        )
    )

    private lateinit var rvMembers: RecyclerView
    private lateinit var rvLastSearchedMembers: RecyclerView
    private lateinit var membersAdapter: MembersAdapter
    private lateinit var lastSearchedAdapter: MembersAdapter
    private lateinit var membersLayoutManager: LinearLayoutManager
    private lateinit var lastSearchedLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_members, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMembers = view.findViewById(R.id.rv_members)
        membersAdapter = MembersAdapter(fakeData)
        membersLayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rvMembers.layoutManager = membersLayoutManager
        rvMembers.adapter = membersAdapter

        rvLastSearchedMembers = view.findViewById(R.id.rv_last_searched_members)
        lastSearchedAdapter = MembersAdapter(fakeData)
        lastSearchedLayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        rvLastSearchedMembers.layoutManager = lastSearchedLayoutManager
        rvLastSearchedMembers.adapter = lastSearchedAdapter
    }
}