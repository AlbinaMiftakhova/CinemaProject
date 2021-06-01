package com.mythesisapp.cinemaproject.domain.messages

import com.mythesisapp.cinemaproject.domain.type.Either
import com.mythesisapp.cinemaproject.domain.type.Failure
import com.mythesisapp.cinemaproject.domain.type.None

interface MessagesRepository {
    fun sendMessage(
        toId: Long,
        message: String,
        image: String
    ): Either<Failure, None>

    fun getChats(needFetch: Boolean): Either<Failure, List<MessageEntity>>

    fun getMessagesWithContact(contactId: Long, needFetch: Boolean): Either<Failure, List<MessageEntity>>

    fun deleteMessagesByUser(messageId: Long): Either<Failure, None>
}