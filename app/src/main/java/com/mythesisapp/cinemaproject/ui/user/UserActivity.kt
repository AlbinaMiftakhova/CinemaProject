package com.mythesisapp.cinemaproject.ui.user

import android.os.Bundle
import com.mythesisapp.cinemaproject.ui.App
import com.mythesisapp.cinemaproject.ui.core.BaseActivity
import com.mythesisapp.cinemaproject.ui.core.BaseFragment

class UserActivity : BaseActivity() {
    override var fragment: BaseFragment = UserFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
