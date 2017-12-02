package com.example.guofeng.training.model.service

import android.app.IntentService
import android.content.Intent
import com.example.guofeng.training.vm.NotificationViewModel

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class BroadcastIntentService : IntentService("BroadcastIntentService") {

    var model: NotificationViewModel? = null

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null && model == null) {
            model = NotificationViewModel()
            model?.createProgressNotification(null)
        }
    }

}
