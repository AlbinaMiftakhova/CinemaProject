package com.mythesisapp.cinemaproject.domain.account

import com.google.gson.annotations.SerializedName

data class AccountEntity(
    @SerializedName("user_id")
    var id: Long,
    var name: String,
    var email: String,
    var surname: String,
    var birthday: String,
    var city: String,
    @SerializedName("token")
    var token: String,
    @SerializedName("user_date")
    var userDate: Long,
    var image: String,
    var password: String
)