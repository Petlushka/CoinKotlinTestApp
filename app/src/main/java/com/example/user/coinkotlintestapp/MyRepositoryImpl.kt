package com.example.user.coinkotlintestapp

import com.example.user.coinkotlintestapp.network.MealsResponse
import com.example.user.coinkotlintestapp.network.MyWebService
import kotlinx.coroutines.Deferred

class MyRepositoryImpl(val service: MyWebService): MyRepository {

    override suspend fun getData(): Deferred<MealsResponse> {
        return service.getData()
    }

}