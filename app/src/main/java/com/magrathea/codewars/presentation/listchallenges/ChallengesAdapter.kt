package com.magrathea.codewars.presentation.listchallenges

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magrathea.codewars.databinding.ListChallengeItemBinding
import com.magrathea.codewars.model.Challenge

class ChallengesAdapter(
    private val challengesList: List<Challenge>
) : RecyclerView.Adapter<ChallengesAdapter.ChallengeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val binding =
            ListChallengeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holderChallenge: ChallengeViewHolder, position: Int) {
        with(holderChallenge) {
            with(challengesList[position]) {
                binding.tvName.text = name
                binding.tvType.text = type.toString()
            }
        }
    }

    override fun getItemCount() = challengesList.size

    inner class ChallengeViewHolder(val binding: ListChallengeItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
