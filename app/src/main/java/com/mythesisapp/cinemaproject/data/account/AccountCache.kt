package com.mythesisapp.cinemaproject.data.account

import com.mythesisapp.cinemaproject.domain.account.AccountEntity
import com.mythesisapp.cinemaproject.domain.type.Either
import com.mythesisapp.cinemaproject.domain.type.None
import com.mythesisapp.cinemaproject.domain.type.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>
    fun checkAuth(): Either<Failure, Boolean>

}