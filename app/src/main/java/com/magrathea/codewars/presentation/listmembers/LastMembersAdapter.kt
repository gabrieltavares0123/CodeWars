package com.magrathea.codewars.presentation.listmembers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.databinding.ListItemMemberBinding
import com.magrathea.codewars.model.User

class LastMembersAdapter(
    private var members: List<User> = emptyList()
) : RecyclerView.Adapter<LastMembersAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ListItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        members[position].let {
            holder.bind(it)
        }
    }

    fun updateData(newMembers: List<User>) {
        val result = DiffUtil.calculateDiff(UserDiff(members, newMembers))
        members = newMembers
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = members.size

    inner class UserViewHolder(private val binding: ListItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            with(binding) {
                this.name = item.realUserName
                this.rank = item.leaderboardPosition.toString()
                this.bestLanguageName = item.bestLanguage?.languageName
                this.bestLanguagePoints = item.bestLanguage?.languagePoints.toString()
            }
        }
    }

    inner class UserDiff(
        private val oldList: List<User>,
        private val newList: List<User>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].username == newList[newItemPosition].username
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}