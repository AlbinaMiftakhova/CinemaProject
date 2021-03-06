package com.mythesisapp.cinemaproject.domain.messages

import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class SendMessage @Inject constructor(
    private val messagesRepository: MessagesRepository
) : UseCase<None, SendMessage.Params>() {

    override suspend fun run(params: Params) = messagesRepository.sendMessage(params.toId, params.message, params.image)

    data class Params(val toId: Long, val message: String, val image: String)
}