package com.mythesisapp.cinemaproject.ui

import android.app.Application
import com.mythesisapp.cinemaproject.presentation.injection.AppModule
import com.mythesisapp.cinemaproject.presentation.injection.CacheModule
import com.mythesisapp.cinemaproject.presentation.injection.RemoteModule
import com.mythesisapp.cinemaproject.presentation.injection.ViewModelModule
import com.mythesisapp.cinemaproject.ui.account.AccountActivity
import com.mythesisapp.cinemaproject.ui.account.AccountFragment
import com.mythesisapp.cinemaproject.ui.core.navigation.RouteActivity
import com.mythesisapp.cinemaproject.ui.register.RegisterActivity
import com.mythesisapp.cinemaproject.ui.register.RegisterFragment
import com.mythesisapp.cinemaproject.ui.firebase.FirebaseService
import com.mythesisapp.cinemaproject.ui.friends.FriendRequestsFragment
import com.mythesisapp.cinemaproject.ui.friends.FriendsFragment
import com.mythesisapp.cinemaproject.ui.home.ChatsFragment
import com.mythesisapp.cinemaproject.ui.home.HomeActivity
import com.mythesisapp.cinemaproject.ui.home.MessagesActivity
import com.mythesisapp.cinemaproject.ui.home.MessagesFragment
import com.mythesisapp.cinemaproject.ui.login.LoginFragment
import com.mythesisapp.cinemaproject.ui.login.ForgetPasswordFragment
import com.mythesisapp.cinemaproject.ui.user.UserActivity
import com.mythesisapp.cinemaproject.ui.user.UserFragment
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)
    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: AccountActivity)
    fun inject(activity: MessagesActivity)
    fun inject(activity: UserActivity)


    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    fun inject(fragment: FriendsFragment)
    fun inject(fragment: FriendRequestsFragment)
    fun inject(fragment: AccountFragment)
    fun inject(fragment: MessagesFragment)
    fun inject(fragment: UserFragment)
    fun inject(fragment: ForgetPasswordFragment)



    //services
    fun inject(service: FirebaseService)

}