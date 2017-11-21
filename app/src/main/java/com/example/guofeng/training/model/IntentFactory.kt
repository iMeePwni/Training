package com.example.guofeng.training.model

import android.content.Context
import android.content.Intent
import com.example.guofeng.training.view.BottomNavigationActivity
import com.example.guofeng.training.view.NetWorkOperationActivity
import com.example.guofeng.training.view.TabbedActivity

/**
 * Created by guofeng on 2017/11/21.
 */
object IntentFactory {

    fun creatIntents(context: Context): ArrayList<Intent> {
        return arrayListOf(
                Intent(context, NetWorkOperationActivity::class.java),
                Intent(context, BottomNavigationActivity::class.java),
                Intent(context, TabbedActivity::class.java)
        )
    }
}