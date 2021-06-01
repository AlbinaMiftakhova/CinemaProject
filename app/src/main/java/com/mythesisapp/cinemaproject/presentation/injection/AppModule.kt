package com.mythesisapp.cinemaproject.presentation.injection

import android.content.Context
import com.mythesisapp.cinemaproject.data.account.AccountCache
import com.mythesisapp.cinemaproject.data.account.AccountRemote
import com.mythesisapp.cinemaproject.data.account.AccountRepositoryImpl
import com.mythesisapp.cinemaproject.data.friends.FriendsCache
import com.mythesisapp.cinemaproject.data.friends.FriendsRemote
import com.mythesisapp.cinemaproject.data.friends.FriendsRepositoryImpl
import com.mythesisapp.cinemaproject.data.media.MediaRepositoryImpl
import com.mythesisapp.cinemaproject.data.messages.MessagesCache
import com.mythesisapp.cinemaproject.data.messages.MessagesRemote
import com.mythesisapp.cinemaproject.data.messages.MessagesRepositoryImpl
import com.mythesisapp.cinemaproject.domain.account.AccountRepository
import com.mythesisapp.cinemaproject.domain.friends.FriendsRepository
import com.mythesisapp.cinemaproject.domain.media.MediaRepository
import com.mythesisapp.cinemaproject.domain.messages.MessagesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }

    @Provides
    @Singleton
    fun provideFriendsRepository(remote: FriendsRemote, accountCache: AccountCache, friendsCache: FriendsCache): FriendsRepository {
        return FriendsRepositoryImpl(accountCache, remote, friendsCache)
    }

    @Provides
    @Singleton
    fun provideMediaRepository(context: Context): MediaRepository {
        return MediaRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideMessagesRepository(remote: MessagesRemote, cache: MessagesCache, accountCache: AccountCache): MessagesRepository {
        return MessagesRepositoryImpl(remote, cache, accountCache)
    }
}