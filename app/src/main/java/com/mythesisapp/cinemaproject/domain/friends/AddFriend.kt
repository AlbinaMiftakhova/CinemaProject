package com.mythesisapp.cinemaproject.domain.friends

import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class AddFriend @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<None, AddFriend.Params>() {

    override suspend fun run(params: Params) = friendsRepository.addFriend(params.email)

    data class Params(val email: String)
}