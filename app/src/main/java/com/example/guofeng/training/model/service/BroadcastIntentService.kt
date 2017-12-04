package com.example.guofeng.training.model.service

import android.app.IntentService
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import com.example.guofeng.training.model.IntentFactory

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class BroadcastIntentService : IntentService("BroadcastIntentService") {


    override fun onHandleIntent(intent: Intent?) {
        val broadcastIntent = Intent()
        broadcastIntent.action = IntentFactory.createLocalBroadcastIntentFilter(this).getAction(0)
        broadcastIntent.putExtra("data", "task finished")
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
    }

}
