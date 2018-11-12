package com.example.user.coinkotlintestapp

import kotlinx.coroutines.*


class MainPresenter(val repository: MyRepository, val activity: MainActivity) {


  //  fun sayHello() = "${repository.getData()} from ${this.javaClass.simpleName}!"

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = repository.getData().await()
            withContext(Dispatchers.Main) {
                activity.showData(result)
            }
        }

    }

}