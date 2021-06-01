package com.mythesisapp.cinemaproject.domain.friends
import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class CancelFriendRequest @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<None, FriendEntity>() {

    override suspend fun run(params: FriendEntity) = friendsRepository.cancelFriendRequest(params)
}