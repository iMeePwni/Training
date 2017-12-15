package com.example.guofeng.training.view.ui

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.NavUtils
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import io.fogcloud.sdk.easylink.api.EasyLink
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
        toolbar.setNavigationOnClickListener {
            val intent = NavUtils.getParentActivityIntent(this)
            // 只是导航到而不是新开一个Activity
            NavUtils.navigateUpTo(this, intent)
        }

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    message.setText(R.string.title_home)
                }
                R.id.navigation_dashboard -> {
                    message.setText(R.string.title_dashboard)
                }
                R.id.navigation_notifications -> {
                    message.setText(R.string.title_notifications)
                }
                R.id.navigation_memory -> {
                    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                    val memoryInfo = ActivityManager.MemoryInfo()
                    activityManager.getMemoryInfo(memoryInfo)
                    val size = memoryInfo.availMem / 1024 / 1024
                    message.text = String.format("%dM", size)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

        EasyLink(this).isAvailable
    }
}
