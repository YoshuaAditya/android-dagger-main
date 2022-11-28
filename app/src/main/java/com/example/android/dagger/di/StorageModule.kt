package com.example.android.dagger.di

import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module
import com.example.android.dagger.storage.SharedPreferencesStorage as SharedPreferencesStorage1

// Tells Dagger this is a Dagger module
// Because of @Binds, StorageModule needs to be an abstract class
@Module
abstract class StorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage1): Storage
}
