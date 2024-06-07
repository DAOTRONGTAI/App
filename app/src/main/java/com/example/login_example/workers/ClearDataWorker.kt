package com.example.login_example.workers

import android.content.Context
import android.widget.Toast
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.login_example.features.MainActivity
import com.example.login_example.repository.WorkRepository
import com.example.login_example.repository.WorkRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ClearDataWorker(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {

    private val workerRepository : WorkRepository = WorkRepositoryImpl.getInstance(applicationContext)!!

    override fun doWork(): Result {
        val builder = Data.Builder()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                workerRepository.clearWordData()
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, " Clear done", Toast.LENGTH_SHORT).show()
                }
            } catch (e : Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, " Clear fail", Toast.LENGTH_SHORT).show()
                }
            }
        }
       return Result.success(builder.build())
    }
}