package com.mythesisapp.cinemaproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mythesisapp.cinemaproject.databinding.ItemChatBinding
import com.mythesisapp.cinemaproject.domain.messages.MessageEntity
import com.mythesisapp.cinemaproject.ui.core.BaseAdapter
import kotlinx.android.synthetic.main.fragment_account.*

open class ChatsAdapter : MessagesAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemChatBinding.inflate(layoutInflater, parent, false)
        return ChatViewHolder(binding)
    }

    class ChatViewHolder(val binding: ItemChatBinding) : BaseAdapter.BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? MessageEntity)?.let {
                binding.message = it
            }
        }
    }
}