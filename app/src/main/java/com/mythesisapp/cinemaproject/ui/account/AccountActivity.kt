package com.mythesisapp.cinemaproject.ui.account

import android.os.Bundle
import com.mythesisapp.cinemaproject.ui.App
import com.mythesisapp.cinemaproject.ui.core.BaseActivity
import com.mythesisapp.cinemaproject.ui.core.BaseFragment

class AccountActivity : BaseActivity() {
    override var fragment: BaseFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
