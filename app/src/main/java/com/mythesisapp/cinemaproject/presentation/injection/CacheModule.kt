package com.mythesisapp.cinemaproject.presentation.injection

import android.content.Context
import android.content.SharedPreferences
import com.mythesisapp.cinemaproject.cache.AccountCacheImpl
import com.mythesisapp.cinemaproject.cache.ChatDatabase
import com.mythesisapp.cinemaproject.cache.SharedPrefsManager
import com.mythesisapp.cinemaproject.data.account.AccountCache
import com.mythesisapp.cinemaproject.data.friends.FriendsCache
import com.mythesisapp.cinemaproject.data.messages.MessagesCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager, chatDatabase: ChatDatabase): AccountCache = AccountCacheImpl(prefsManager, chatDatabase)


    @Provides
    @Singleton
    fun provideChatDatabase(context: Context): ChatDatabase {
        return ChatDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideFriendsCache(chatDatabase: ChatDatabase): FriendsCache {
        return chatDatabase.friendsDao
    }


    @Provides
    @Singleton
    fun provideMessagesCache(chatDatabase: ChatDatabase): MessagesCache {
        return chatDatabase.messagesDao
    }
}