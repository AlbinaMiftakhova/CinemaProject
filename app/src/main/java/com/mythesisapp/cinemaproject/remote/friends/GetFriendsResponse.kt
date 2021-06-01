package com.mythesisapp.cinemaproject.remote.friends

import com.google.gson.annotations.SerializedName
import com.mythesisapp.cinemaproject.domain.friends.FriendEntity
import com.mythesisapp.cinemaproject.remote.core.BaseResponse

class GetFriendsResponse (
    success: Int,
    message: String,
    @SerializedName("friends")
    val friends: List<FriendEntity>
) : BaseResponse(success, message)