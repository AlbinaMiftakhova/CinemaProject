package com.mythesisapp.cinemaproject.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mythesisapp.cinemaproject.domain.account.*
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    val registerUseCase: Register,
    val loginUseCase: Login,
    val getAccountUseCase: GetAccount,
    val logoutUseCase: Logout,
    val editAccountUseCase: EditAccount,
    val updateLastSeenUseCase: UpdateLastSeen,
    val forgetPasswordUseCase: ForgetPassword
) : BaseViewModel() {
    var editAccountData: MutableLiveData<AccountEntity> = MutableLiveData()
    var registerData: MutableLiveData<None> = MutableLiveData()
    var accountData: MutableLiveData<AccountEntity> = MutableLiveData()
    var logoutData: MutableLiveData<None> = MutableLiveData()
    var forgetPasswordData: MutableLiveData<None> = MutableLiveData()

    fun register(email: String, name: String, surname: String,
                 city: String, birthday: String, image:String, password: String) {
        registerUseCase(Register.Params(email, name,surname, city, birthday, image, password)) { it.either(::handleFailure, ::handleRegister) }
    }

    fun login(email: String, password: String) {
        loginUseCase(Login.Params(email, password)) {
            it.either(::handleFailure, ::handleAccount)
        }
    }

    fun forgetPassword(email: String) {
        forgetPasswordUseCase(ForgetPassword.Params(email)) { it.either(::handleFailure, ::handleForgetPassword) }
    }

    fun getAccount() {
        getAccountUseCase(None()) { it.either(::handleFailure, ::handleAccount) }
    }

    fun logout() {
        logoutUseCase(None()) { it.either(::handleFailure, ::handleLogout) }
    }

    private fun handleForgetPassword(none: None) {
        this.forgetPasswordData.value = none
    }

    fun editAccount(entity: AccountEntity) {
        editAccountUseCase(entity) { it.either(::handleFailure, ::handleEditAccount) }
    }

    private fun handleRegister(none: None) {
        this.registerData.value = none
    }

    fun updateLastSeen() {
        updateLastSeenUseCase(None()) { it.either(::handleFailure) {} }
    }

    private fun handleAccount(account: AccountEntity) {
        this.accountData.value = account
    }

    private fun handleEditAccount(account: AccountEntity) {
        this.editAccountData.value = account
    }

    private fun handleLogout(none: None) {
        this.logoutData.value = none
    }

    override fun onCleared() {
        super.onCleared()
        registerUseCase.unsubscribe()
        loginUseCase.unsubscribe()
        getAccountUseCase.unsubscribe()
        logoutUseCase.unsubscribe()
        updateLastSeenUseCase.unsubscribe()
        forgetPasswordUseCase.unsubscribe()
    }
}