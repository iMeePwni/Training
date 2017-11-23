package com.example.guofeng.training.vm

import android.app.NotificationManager
import android.content.Context
import android.databinding.BaseObservable
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.View
import com.example.guofeng.training.R

/**
 * Created by guofeng on 2017/11/21.
 */
class NotificationViewModel : BaseObservable() {

    fun onButtonClick(view: View) {
        val context = view.context
        when (view.id) {
            R.id.create_notification -> {
                val builder = NotificationCompat.Builder(context, NotificationManagerCompat.IMPORTANCE_HIGH.toString())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My Notification")
                        .setContentText("Hello World!")
                val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(R.id.notification_channel_id, builder.build())
            }
        }
    }
}