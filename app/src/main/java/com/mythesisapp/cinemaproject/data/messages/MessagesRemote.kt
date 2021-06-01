package com.mythesisapp.cinemaproject.data.messages

import com.mythesisapp.cinemaproject.domain.messages.MessageEntity
import com.mythesisapp.cinemaproject.domain.type.Either
import com.mythesisapp.cinemaproject.domain.type.Failure
import com.mythesisapp.cinemaproject.domain.type.None

interface MessagesRemote {

    fun getChats(userId: Long, token: String): Either<Failure, List<MessageEntity>>

    fun getMessagesWithContact(contactId: Long, userId: Long, token: String): Either<Failure, List<MessageEntity>>

    fun sendMessage(
        fromId: Long,
        toId: Long,
        token: String,
        message: String,
        image: String
    ): Either<Failure, None>

    fun deleteMessagesByUser(userId: Long, messageId: Long, token: String): Either<Failure, None>
}