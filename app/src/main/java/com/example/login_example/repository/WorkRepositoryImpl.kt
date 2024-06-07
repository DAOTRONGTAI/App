package com.example.login_example.repository

import android.content.Context
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkRepositoryImpl(applicationContext: Context) : WorkRepository {

    companion object {
        @Volatile
        private var mInstance: WorkRepositoryImpl? = null
        @JvmStatic
        fun getInstance(context: Context): WorkRepositoryImpl? {
            if (mInstance == null) {
                synchronized(WorkRepositoryImpl::class.java) {
                    if (mInstance == null) {
//                        WorkRepositoryImpl(context.applicationContext!!).also { mInstance = it }
                        mInstance = WorkRepositoryImpl(context.applicationContext)
                    }
                }
            }
            return mInstance
        }
    }


    override suspend fun clearWordData(): Int {
       return withContext(Dispatchers.IO) {
           val radicalDataClearResult = clearRadicalData()

           // Assuming the final result you want to return is just an example
           radicalDataClearResult
       }
    }

    private fun clearRadicalData(): Int {
        // Implement your coroutine-friendly version here
        return 1 // Example return
    }
}