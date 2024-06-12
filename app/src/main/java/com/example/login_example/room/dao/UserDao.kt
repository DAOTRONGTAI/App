package com.example.login_example.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.login_example.data.User

interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getAllUsers() : MutableList<User>

    @Insert
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}