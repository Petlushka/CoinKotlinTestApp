package com.example.user.coinkotlintestapp.model

import android.arch.persistence.room.RoomDatabase


abstract class AppDatabase: RoomDatabase() {

    abstract fun testDao(): TestDao

}
