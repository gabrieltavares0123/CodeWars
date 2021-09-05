package com.magrathea.codewars.presentation.listmembers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.databinding.ListItemMemberBinding
import com.magrathea.codewars.domain.model.User

class MembersAdapter(
    var users: List<User>?,
) : RecyclerView.Adapter<MembersAdapter.MemberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val memberItemBinding =
            ListItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(memberItemBinding)
    }

    override fun onBindViewHolder(holderMember: MemberViewHolder, position: Int) {
        with(holderMember) {
            with(users?.get(position)) {
                binding.tvName.text = this?.name
                binding.tvRank.text = this?.ranks?.overall.toString()
                binding.tvBestLanguage.text = this?.bestLanguage?.languageName ?: "none"
                binding.tvBestLanguageRank.text = this?.bestLanguage?.rank.toString()
            }
        }
    }

    override fun getItemCount() = users?.size ?: 0

    inner class MemberViewHolder(val binding: ListItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root)
}