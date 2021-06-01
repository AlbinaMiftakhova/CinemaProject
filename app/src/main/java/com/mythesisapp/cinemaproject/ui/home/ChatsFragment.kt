package com.mythesisapp.cinemaproject.ui.home

import android.os.Bundle
import android.view.View
import com.mythesisapp.cinemaproject.R
import com.mythesisapp.cinemaproject.cache.ChatDatabase
import com.mythesisapp.cinemaproject.domain.messages.MessageEntity
import com.mythesisapp.cinemaproject.presentation.viewmodel.MessagesViewModel
import com.mythesisapp.cinemaproject.ui.App
import com.mythesisapp.cinemaproject.ui.core.BaseFragment
import com.mythesisapp.cinemaproject.ui.core.BaseListFragment
import com.mythesisapp.cinemaproject.ui.core.ext.onFailure
import com.mythesisapp.cinemaproject.ui.core.ext.onSuccess
import androidx.lifecycle.Observer


class ChatsFragment : BaseListFragment() {
    override val viewAdapter = ChatsAdapter()

    override val titleToolbar = R.string.chats

    private lateinit var messagesViewModel: MessagesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messagesViewModel = viewModel {
            onSuccess(progressData, ::updateProgress)
            onFailure(failureData, ::handleFailure)
        }

        viewAdapter.setOnClick( { it, v ->
            (it as? MessageEntity)?.let {
                val contact = it.contact
                if (contact != null) {
                    navigator.showChatWithContact(contact.id, contact.name, requireActivity())
                }
            }
        })

        ChatDatabase.getInstance(requireContext()).messagesDao.getLiveChats().observe(this, Observer {
            val list = it.distinctBy { it.contact?.id }.toList()
            handleChats(list)
        })
    }

    override fun onResume() {
        super.onResume()

        messagesViewModel.getChats()
    }

    fun handleChats(messages: List<MessageEntity>?) {
        if (messages != null && messages.isNotEmpty()) {
            viewAdapter.submitList(messages)
        }
    }
}