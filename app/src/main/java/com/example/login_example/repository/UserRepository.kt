package com.example.login_example.repository

import com.example.login_example.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserRepository {

    suspend fun getUser (user: User)

    suspend fun changeName (userName : String)

    suspend fun changePass (passOld: String, passNew: String)

    suspend fun login(userName: String, passWord: String)

}