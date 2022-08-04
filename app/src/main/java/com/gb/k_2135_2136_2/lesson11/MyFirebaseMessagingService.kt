package com.gb.k_2135_2136_2.lesson11

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.gb.k_2135_2136_2.MainActivity
import com.gb.k_2135_2136_2.R
import com.gb.k_2135_2136_2.utils.CHANNEL_HIGH_ID
import com.gb.k_2135_2136_2.utils.NOTIFICATION_ID1
import com.gb.k_2135_2136_2.utils.NOTIFICATION_KEY_BODY
import com.gb.k_2135_2136_2.utils.NOTIFICATION_KEY_TITLE
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d("@@@", "$token ")
        pushNotification(token, token)
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("@@@", "$message ")
        val data = message.data
        val title = data[NOTIFICATION_KEY_TITLE]
        val body = data[NOTIFICATION_KEY_BODY]
        if (!title.isNullOrEmpty() && !body.isNullOrEmpty()) {
            pushNotification(title, body)
        }
        super.onMessageReceived(message)
    }

    private fun pushNotification(title: String, body: String) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        val notificationIntent = Intent(applicationContext, MainActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

        val contentIntent = PendingIntent.getActivity(
            this,
            1,
            notificationIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        
        val notification = NotificationCompat.Builder(this, CHANNEL_HIGH_ID).apply {
            setContentTitle(title)
            setContentText(body)
            setSmallIcon(R.drawable.ic_kotlin_logo)
            priority = NotificationCompat.PRIORITY_MAX
            setContentIntent(contentIntent)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelHigh = NotificationChannel(
                CHANNEL_HIGH_ID, CHANNEL_HIGH_ID,
                NotificationManager.IMPORTANCE_HIGH
            )
            channelHigh.description = "Канал для бла бла бла"
            notificationManager.createNotificationChannel(channelHigh)
        }
        notificationManager.notify(NOTIFICATION_ID1, notification.build())

    }
}