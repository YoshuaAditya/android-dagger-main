package com.example.android.dagger.splash

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(val userManager: UserManager) {

    fun checkUser(context: Context) {
        if (!userManager.isUserLoggedIn()) {//this is dangerous, will be fixed later
            if (!userManager.isUserRegistered()) {
                context.startActivity(Intent(context, RegistrationActivity::class.java))

            } else {
                context.startActivity(Intent(context, LoginActivity::class.java))
            }
        }
    }

}