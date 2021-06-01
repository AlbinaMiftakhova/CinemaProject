package com.mythesisapp.cinemaproject.ui.home

import android.os.Bundle
import com.mythesisapp.cinemaproject.ui.App
import com.mythesisapp.cinemaproject.ui.core.BaseActivity
import com.mythesisapp.cinemaproject.ui.core.BaseFragment

class MessagesActivity : BaseActivity() {

    override var fragment: BaseFragment = MessagesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
