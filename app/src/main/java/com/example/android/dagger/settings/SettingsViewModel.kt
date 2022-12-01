/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.settings

import android.util.Log
import com.example.android.dagger.user.UserDataRepository
import com.example.android.dagger.user.UserManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * SettingsViewModel is the ViewModel that [SettingsActivity] uses to handle complex logic.
 */
class SettingsViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) {
    private var TAG = "SettingsActivity"
    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
    fun startRStream() {
        //Rxkotlin
        val numbers = Observable.range(1, 6)
        val strings = Observable.just("One", "Two", "Three", "Four", "Five", "Six" )
        val zipped = Observable.zip(strings, numbers) { s, n -> "$s $n" }
        zipped.subscribe(::println)
        //Rxjava
//        val myObservable = getObservable()
//        val myObserver = getObserver()
//        myObservable.subscribe(myObserver)
    }
    fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }
            override fun onNext(s: String) {
                Log.d(TAG, "onNext: $s")
            }
            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.message)
            }
            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }
        }
    }
    fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }
}
