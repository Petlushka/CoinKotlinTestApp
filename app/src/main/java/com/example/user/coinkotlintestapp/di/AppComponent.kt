package com.example.user.coinkotlintestapp.di

import com.example.user.coinkotlintestapp.MainActivity
import com.example.user.coinkotlintestapp.MainPresenter
import com.example.user.coinkotlintestapp.network.MyWebService
import org.koin.core.parameter.parametersOf
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class AppComponent: KoinComponent {

    val service: MyWebService by inject()
}