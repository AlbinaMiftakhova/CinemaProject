package com.mythesisapp.cinemaproject.domain.account

import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.Either
import com.mythesisapp.cinemaproject.domain.type.Failure
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class CheckAuth @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<Boolean, None>() {

    override suspend fun run(params: None): Either<Failure, Boolean> = accountRepository.checkAuth()
}