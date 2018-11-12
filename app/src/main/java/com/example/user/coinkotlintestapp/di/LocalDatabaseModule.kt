package com.example.user.coinkotlintestapp.di


import android.arch.persistence.room.Room
import com.example.user.coinkotlintestapp.model.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val localDbModule = module {

    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "localDb").build() }
}