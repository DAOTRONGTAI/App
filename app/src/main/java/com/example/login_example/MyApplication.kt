package com.example.login_example

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.IntentFilter
import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.login_example.ultil.broadcast.NetWorkChangeReceiver
import org.greenrobot.eventbus.EventBus
import android.graphics.Color
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.room.Room
import com.example.login_example.room.AppDatabase
import com.google.firebase.FirebaseApp


//@HiltAndroidApp
class MyApplication : Application(), LifecycleObserver {


    private var netWorkChangeReceiver: NetWorkChangeReceiver? = null
    var context : Context?=null

    companion object {
        const val CHANNEL_ID: String = "push_notify"
        private val DATABASE_NAME: String = "USER_DATABASE"

    }

    override fun onCreate() {
        super.onCreate()
        context = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        FirebaseApp.initializeApp(context!!)
//        AndroidUtils.init(this)

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        netWorkChangeReceiver = NetWorkChangeReceiver()
        creatChannelNotification()

//        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }

    private fun creatChannelNotification() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(CHANNEL_ID, "PushNotifycation", NotificationManager.IMPORTANCE_DEFAULT)
//            val manager = getSystemService(NotificationManager::class.java)
//            manager.createNotificationChannel(channel)
//        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = "key_push_notification"
            val channelName : CharSequence = "Push notification"
            val improtance = NotificationManager.IMPORTANCE_HIGH
            val mNotificationManager = context!!.applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(channel,channelName,improtance)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mNotificationManager.createNotificationChannel(notificationChannel)
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded(){
        EventBus.getDefault().unregister(this)
        unregisterReceiver(netWorkChangeReceiver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppForegrounded(){

        val filterMobileNetWork = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        val filterWifi = IntentFilter("android.net.wifi.WIFI_STATE_CHANGED")

        registerReceiver(netWorkChangeReceiver, filterMobileNetWork)
        registerReceiver(netWorkChangeReceiver, filterWifi)

        EventBus.getDefault().register(this)
    }



}
