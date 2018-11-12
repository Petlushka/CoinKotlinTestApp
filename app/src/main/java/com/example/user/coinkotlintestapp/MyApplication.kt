package com.example.user.coinkotlintestapp

import android.app.Application
import com.example.user.coinkotlintestapp.di.AppComponent
import com.example.user.coinkotlintestapp.di.appModule
import com.example.user.coinkotlintestapp.di.localDbModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class MyApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, localDbModule))

    }
}