package com.mythesisapp.cinemaproject.remote.account

import com.mythesisapp.cinemaproject.domain.account.AccountEntity
import com.mythesisapp.cinemaproject.remote.core.BaseResponse
class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)