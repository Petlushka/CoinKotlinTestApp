package com.example.user.coinkotlintestapp

import com.example.user.coinkotlintestapp.network.MealsResponse
import kotlinx.coroutines.Deferred


interface MyRepository {
    suspend fun getData(): Deferred<MealsResponse>
}