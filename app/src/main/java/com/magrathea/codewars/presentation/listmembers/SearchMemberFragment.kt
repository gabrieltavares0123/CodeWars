package com.magrathea.codewars.presentation.listmembers

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.magrathea.codewars.R
import com.magrathea.codewars.databinding.FragmentSearchMemberBinding
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.util.ResourceObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMemberFragment : Fragment() {
    private companion object {
        const val TAG = "SearchMemberFragment"
    }

    private val viewModel: SearchMemberViewModel by viewModels()

    // Last searched members.
    private lateinit var lastMembersLayoutManager: LinearLayoutManager
    private lateinit var lastMembersAdapter: LastMembersAdapter
    private lateinit var binding: FragmentSearchMemberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentSearchMemberBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupLastMembersRecyclerView()
    }

    private fun setupLastMembersRecyclerView() {
        lastMembersLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvLastMembers.layoutManager = lastMembersLayoutManager
        binding.viewModel = viewModel

        lastMembersAdapter = LastMembersAdapter()
        binding.rvLastMembers.adapter = lastMembersAdapter
        viewModel.sortMembersByEmission
            .observe(viewLifecycleOwner, ResourceObserver(lastMembersAdapter::submitList))
        viewModel.searchForEmission
            .observe(viewLifecycleOwner, ResourceObserver(lastMembersAdapter::submitList))
    }

    override fun onStart() {
        super.onStart()
        viewModel.sortMembersBy(SortType.SEARCH_DATE)
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
                viewModel.searchFor(query)
                searchView.onActionViewCollapsed()
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.it_by_honor -> {
                viewModel.sortMembersBy(SortType.HONOR)
                true
            }
            R.id.it_by_search_date -> {
                viewModel.sortMembersBy(SortType.SEARCH_DATE)
                true
            }
            else -> {
                false
            }
        }
    }
}