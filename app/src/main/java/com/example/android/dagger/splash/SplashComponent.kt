package com.example.android.dagger.splash

import dagger.Subcomponent

@Subcomponent
interface SplashComponent {
    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplasActivity)
}

