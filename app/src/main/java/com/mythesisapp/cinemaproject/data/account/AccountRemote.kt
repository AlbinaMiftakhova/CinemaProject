package com.mythesisapp.cinemaproject.data.account

import com.mythesisapp.cinemaproject.domain.account.AccountEntity
import com.mythesisapp.cinemaproject.domain.type.Either
import com.mythesisapp.cinemaproject.domain.type.None
import com.mythesisapp.cinemaproject.domain.type.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        surname: String,
        city: String,
        birthday: String,
        image: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>

    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>

    fun editUser(
        userId: Long,
        email: String,
        name: String,
        password: String,
        birthday:String,
        city: String,
        surname: String,
        token: String,
        image: String
    ): Either<Failure, AccountEntity>

    fun updateAccountLastSeen(userId: Long, token: String, lastSeen: Long): Either<Failure, None>

    fun forgetPassword(email: String): Either<Failure, None>
}