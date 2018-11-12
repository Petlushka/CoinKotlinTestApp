package com.example.user.coinkotlintestapp.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MyWebService {

    @GET("random.php")
    fun getData(): Deferred<MealsResponse>
}
