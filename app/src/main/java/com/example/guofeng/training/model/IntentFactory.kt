package com.example.guofeng.training.model

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.example.guofeng.training.view.ui.*

/**
 * Created by guofeng on 2017/11/21.
 */
object IntentFactory {

    fun createIntents(context: Context): ArrayList<Intent> {
        return arrayListOf(
                Intent(context, NetWorkOperationActivity::class.java),
                Intent(context, BottomNavigationActivity::class.java),
                Intent(context, TabbedActivity::class.java),
                Intent(context, NavigationDrawerActivity::class.java),
                Intent(context, NotificationActivity::class.java),
                Intent(context, ScrollingActivity::class.java),
                Intent(context, LoginActivity::class.java),
                Intent(context, BasicActivity::class.java),
                Intent(context, LeakCanaryActivity::class.java),
                Intent(context, CardViewActivity::class.java),
                Intent(context, PaletteActivity::class.java),
                Intent(context, AnimatorActivity::class.java),
                Intent(context, EditTextActivity::class.java),
                Intent(context, IntentServiceActivity::class.java),
                Intent(context, CursorLoaderActivity::class.java)
        )
    }

    private val LOCAL_BROADCAST_INTENT_FILTER = "local"

    fun createLocalBroadcastIntentFilter(): IntentFilter {
        return IntentFilter(LOCAL_BROADCAST_INTENT_FILTER)
    }
}