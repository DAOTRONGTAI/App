package com.example.login_example.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.login_example.data.User
import com.example.login_example.room.dao.NoteDao
import com.example.login_example.room.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun noteDao() : NoteDao

}