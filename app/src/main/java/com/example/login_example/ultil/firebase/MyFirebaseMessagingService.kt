package com.example.login_example.ultil.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.login_example.features.MainActivity
import com.example.login_example.R
import com.example.login_example.MyApplication
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val notification = message.notification ?: return
        val title = notification.title
        val messages = notification.body

        sendNotifycation(title, messages)
    }


    private fun getPendingIntent(intent: Intent, user_id: String): PendingIntent? {
        var pendingIntent: PendingIntent? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pendingIntent = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(intent)
                getPendingIntent(
                    user_id.toInt(),
                    PendingIntent.FLAG_IMMUTABLE
                )
            }
        } else {
            pendingIntent = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(intent)
                getPendingIntent(
                    user_id.toInt(),
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            }
        }
        return pendingIntent
    }

    private fun sendNotifycation(title: String?, messages: String?) {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationBuilder = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(messages)
            .setSmallIcon(R.drawable.ic_avatar)
            .setContentIntent(pendingIntent)

        val notification = notificationBuilder.build()
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager?.notify(1, notification)
    }
}
