package com.mythesisapp.cinemaproject.domain.type

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object EmailAlreadyExistError : Failure()
    object AlreadyFriendError : Failure()
    object AlreadyRequestedFriendError : Failure()
    object ContactNotFoundError : Failure()
    object AuthError : Failure()
    object TokenError : Failure()
    object NoSavedAccountsError : Failure()
    object EmailNotRegisteredError : Failure()
    object CantSendEmailError : Failure()
    object FilePickError : Failure()
}