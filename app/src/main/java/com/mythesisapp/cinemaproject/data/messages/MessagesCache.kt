package com.mythesisapp.cinemaproject.data.messages

import com.mythesisapp.cinemaproject.domain.messages.MessageEntity

interface MessagesCache {
    fun saveMessage(entity: MessageEntity)

    fun saveMessages(entities: List<MessageEntity>)

    fun getChats(): List<MessageEntity>

    fun getMessagesWithContact(contactId: Long): List<MessageEntity>

    fun deleteMessagesByUser(messageId: Long)

}