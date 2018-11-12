package com.example.user.coinkotlintestapp.di

import com.example.user.coinkotlintestapp.MainActivity
import com.example.user.coinkotlintestapp.MainPresenter
import com.example.user.coinkotlintestapp.MyRepository
import com.example.user.coinkotlintestapp.MyRepositoryImpl
import com.example.user.coinkotlintestapp.network.MyWebService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    factory { (activity: MainActivity) -> MainPresenter(get(), activity) }

    single<MyRepository> { MyRepositoryImpl(get()) }

    single { createOkHttpClient() }

    single { createWebService<MyWebService>(get(),  "http://www.themealdb.com/api/json/v1/1/random.php/") }

}


fun createOkHttpClient() : OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    return retrofit.create(T::class.java)
}