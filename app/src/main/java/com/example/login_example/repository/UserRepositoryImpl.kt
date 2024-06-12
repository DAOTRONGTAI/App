package com.example.login_example.repository

import com.example.login_example.data.User

class UserRepositoryImpl : UserRepository {
    override suspend fun getUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun changeName(userName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun changePass(passOld: String, passNew: String) {
        TODO("Not yet implemented")
    }

    override suspend fun login(userName: String, passWord: String) {
        TODO("Not yet implemented")
    }
}