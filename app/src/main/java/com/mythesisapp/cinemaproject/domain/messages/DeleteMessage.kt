package com.mythesisapp.cinemaproject.domain.messages

import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class DeleteMessage @Inject constructor(
    private val messagesRepository: MessagesRepository
) : UseCase<None, DeleteMessage.Params>() {

    override suspend fun run(params: Params) = messagesRepository.deleteMessagesByUser(params.messageId)

    data class Params(val messageId: Long)
}