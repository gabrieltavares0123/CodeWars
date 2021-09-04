package com.magrathea.codewars.presentation.listmembers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.databinding.ListItemMemberHorizontalBinding
import com.magrathea.codewars.domain.model.User

class MembersHorizontalAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<MembersHorizontalAdapter.MemberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val memberItemBinding =
            ListItemMemberHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(memberItemBinding)
    }

    override fun onBindViewHolder(holderMember: MemberViewHolder, position: Int) {
        with(holderMember) {
            with(users[position]) {
                binding.tvName.text = name
                binding.tvRank.text = ranks?.overall.toString()
                binding.tvBestLanguage.text = bestLanguage?.languageName ?: "none"
                binding.tvBestLanguageRank.text = bestLanguage?.rank.toString()
            }
        }
    }

    override fun getItemCount() = users.size

    inner class MemberViewHolder(val binding: ListItemMemberHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)
}