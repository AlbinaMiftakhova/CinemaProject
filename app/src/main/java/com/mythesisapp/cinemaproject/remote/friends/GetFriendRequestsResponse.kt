package com.mythesisapp.cinemaproject.remote.friends

import com.google.gson.annotations.SerializedName
import com.mythesisapp.cinemaproject.domain.friends.FriendEntity
import com.mythesisapp.cinemaproject.remote.core.BaseResponse

class GetFriendRequestsResponse (
    success: Int,
    message: String,
    @SerializedName("friend_requests")
    val friendsRequests: List<FriendEntity>
) : BaseResponse(success, message)