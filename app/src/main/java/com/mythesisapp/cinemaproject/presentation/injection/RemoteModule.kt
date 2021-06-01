package com.mythesisapp.cinemaproject.presentation.injection

import com.mythesisapp.cinemaproject.BuildConfig
import com.mythesisapp.cinemaproject.data.account.AccountRemote
import com.mythesisapp.cinemaproject.data.friends.FriendsRemote
import com.mythesisapp.cinemaproject.data.messages.MessagesRemote
import com.mythesisapp.cinemaproject.remote.account.AccountRemoteImpl
import com.mythesisapp.cinemaproject.remote.core.Request
import com.mythesisapp.cinemaproject.remote.friends.FriendsRemoteImpl
import com.mythesisapp.cinemaproject.remote.messages.MessagesRemoteImpl
import com.mythesisapp.cinemaproject.remote.service.ApiService
import com.mythesisapp.cinemaproject.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }

    @Singleton
    @Provides
    fun provideFriendsRemote(request: Request, apiService: ApiService): FriendsRemote {
        return FriendsRemoteImpl(request, apiService)
    }

    @Singleton
    @Provides
    fun provideMessagesRemote(request: Request, apiService: ApiService): MessagesRemote {
        return MessagesRemoteImpl(request, apiService)
    }
}