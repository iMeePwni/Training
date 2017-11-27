package com.example.guofeng.training.vm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.View
import com.example.guofeng.training.R
import com.example.guofeng.training.app.App
import com.example.guofeng.training.view.MainActivity

@Suppress("UNUSED_PARAMETER")
/**
 * Created by guofeng on 2017/11/21.
 */
class NotificationViewModel : BaseObservable() {

    private val context = App.instance
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val builder = NotificationCompat.Builder(context, NotificationManagerCompat.IMPORTANCE_MAX.toString())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("My Notification")
            .setContentText("Hello World!")

    fun createNotification(view: View) {
        builder.setContentIntent(PendingIntent.getActivity(context,
                0,
                Intent(context, MainActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT))!!
        notifyNotification()
    }

    private var updateNum = 0

    fun updateNotification(view: View) {
        builder.setContentText("Hello ${updateNum++} World!")
        notifyNotification()
    }

    private fun notifyNotification() {
        notificationManager.notify(R.id.notification_channel_id, builder.build())
    }

    fun cancelNotification(view: View) {
        notificationManager.cancel(R.id.notification_channel_id)
    }

    private val bigViewBuilder = NotificationCompat.Builder(context, NotificationManagerCompat.IMPORTANCE_MAX.toString())
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentText("Hello World")
            .setStyle(NotificationCompat.BigTextStyle().bigText("This  is big text"))

    fun createBigViewNotification(view: View) {
        notificationManager.notify(R.id.notification_big_view_channel_id, bigViewBuilder.build())
    }
}