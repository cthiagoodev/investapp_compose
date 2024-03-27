package br.com.thiagoodev.investapp.android

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InvestAppApplication : Application() {
    override fun onCreate() {
        Firebase.initialize(this)
        super.onCreate()
    }
}