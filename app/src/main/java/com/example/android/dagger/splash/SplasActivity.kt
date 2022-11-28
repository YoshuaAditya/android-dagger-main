package com.example.android.dagger.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import javax.inject.Inject
import kotlin.concurrent.thread

//If you give name Splash it will give warning app should not provide its own launch screen
//its because google recommends using splash screen api but still many restrictions
class SplasActivity : AppCompatActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel
    lateinit var splashComponent: SplashComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        // Ask Dagger to inject our dependencies
        //When using Activities, inject Dagger in the Activity's onCreate method before calling super.onCreate to avoid issues with fragment restoration.
        splashComponent =(application as MyApplication).appComponent.splashComponent().create()
        splashComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        thread(start=true) {
            Thread.sleep(2000L)
            splashViewModel.checkUser(this)
            finish()
        }
    }
}