package com.example.login_example.repository

import io.reactivex.Single

interface WorkRepository {

    suspend fun clearWordData(): Int

}