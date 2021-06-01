package com.mythesisapp.cinemaproject.remote.messages

import com.mythesisapp.cinemaproject.domain.messages.MessageEntity
import com.mythesisapp.cinemaproject.remote.core.BaseResponse

class GetMessagesResponse (
    success: Int,
    message: String,
    val messages: List<MessageEntity>
) : BaseResponse(success, message)