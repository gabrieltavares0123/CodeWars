package com.magrathea.codewars.presentation.listmembers

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.R
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.model.User
import com.magrathea.codewars.util.ResourceObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListMembersFragment : Fragment() {
    private val viewModel: ListMembersViewModel by viewModels()
    private lateinit var rvMembers: RecyclerView
    private lateinit var rvLastSearchedMembers: RecyclerView
    private lateinit var membersAdapter: MembersAdapter
    private lateinit var lastSearchedAdapter: MembersHorizontalAdapter
    private lateinit var membersLayoutManager: LinearLayoutManager
    private lateinit var lastSearchedLayoutManager: LinearLayoutManager

    private val fakeUsersList = listOf(
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
        User(
            username = "saasf",
            name = "sadfag",
            honor = 10,
            leaderboardPosition = 1,
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list_members, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMembers = view.findViewById(R.id.rv_members)
        membersAdapter = MembersAdapter(fakeUsersList)
        membersLayoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rvMembers.layoutManager = membersLayoutManager
        rvMembers.adapter = membersAdapter

        rvLastSearchedMembers = view.findViewById(R.id.rv_last_searched_members)
//        lastSearchedAdapter = MembersHorizontalAdapter(fakeData)
        lastSearchedLayoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        rvLastSearchedMembers.layoutManager = lastSearchedLayoutManager
//        rvLastSearchedMembers.adapter = lastSearchedAdapter

        setupMembersData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_members_menu, menu)

        val searchView = menu.findItem(R.id.it_list_members_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchQuery(query)
                searchView.onActionViewCollapsed()
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.it_by_honor -> {
                viewModel.sortMembers(SortType.HONOR)
                true
            }
            R.id.it_by_search_date -> {
                viewModel.sortMembers(SortType.SEARCH_DATE)
                true
            }
            else -> {
                false
            }
        }
    }

    private fun setupMembersData() {
        viewModel.sortedMembers.observe(
            viewLifecycleOwner,
            ResourceObserver {
                membersAdapter.users = it
            }
        )
    }
}