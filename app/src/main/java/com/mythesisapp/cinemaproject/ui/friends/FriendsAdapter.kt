package com.mythesisapp.cinemaproject.ui.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.mythesisapp.cinemaproject.R
import com.mythesisapp.cinemaproject.databinding.ItemFriendBinding
import com.mythesisapp.cinemaproject.domain.friends.FriendEntity
import com.mythesisapp.cinemaproject.ui.core.BaseAdapter

open class FriendsAdapter : BaseAdapter<FriendEntity, FriendsAdapter.FriendViewHolder>(FriendsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendBinding.inflate(layoutInflater, parent, false)
        return FriendViewHolder(binding)
    }

    class FriendViewHolder(val binding: ItemFriendBinding) : BaseViewHolder(binding.root) {
        init {
            binding.btnRemove.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? FriendEntity)?.let {
                binding.friend = it
            }
        }
    }
    class FriendsDiffCallback : DiffUtil.ItemCallback<FriendEntity>() {

        override fun areItemsTheSame(oldItem: FriendEntity, newItem: FriendEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FriendEntity, newItem: FriendEntity): Boolean {
            return oldItem == newItem
        }
    }

}
