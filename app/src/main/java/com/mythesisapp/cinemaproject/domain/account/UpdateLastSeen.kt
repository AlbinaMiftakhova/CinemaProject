package com.mythesisapp.cinemaproject.domain.account

import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class UpdateLastSeen @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, None>() {

    override suspend fun run(params: None) = accountRepository.updateAccountLastSeen()
}