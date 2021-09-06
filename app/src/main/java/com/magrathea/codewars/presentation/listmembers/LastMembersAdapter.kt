package com.magrathea.codewars.presentation.listmembers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.databinding.ListItemMemberBinding
import com.magrathea.codewars.model.User

class LastMembersAdapter(
    private val listener: (username: String) -> Unit,
) :
    ListAdapter<User, LastMembersAdapter.UserViewHolder>(LastMembersAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { listener(item.username) }
        holder.bind(item)
    }

    class UserViewHolder private constructor(private val binding: ListItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: User) {
            with(binding) {
                this.name = data.realUserName
                this.rank = data.leaderboardPosition.toString()
                this.honor = data.honor.toString()
                this.bestLanguageName = data.bestLanguage?.languageName
                this.bestLanguagePoints = data.bestLanguage?.languagePoints.toString()
            }
        }

        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val binding = ListItemMemberBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return UserViewHolder(binding)
            }
        }
    }

    private companion object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}