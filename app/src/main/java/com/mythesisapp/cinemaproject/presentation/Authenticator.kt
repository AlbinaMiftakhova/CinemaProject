package com.mythesisapp.cinemaproject.presentation

import com.mythesisapp.cinemaproject.domain.account.CheckAuth
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor(
    val checkAuth: CheckAuth
) {
    fun userLoggedIn(body: (Boolean) -> Unit) {
        checkAuth(None()) {
            it.either({ body(false) }, { body(it) })
        }
    }
}