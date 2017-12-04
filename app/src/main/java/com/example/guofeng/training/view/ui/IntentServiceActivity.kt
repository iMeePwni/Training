package com.example.guofeng.training.view.ui

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.Toast
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import com.example.guofeng.training.model.IntentFactory
import com.example.guofeng.training.model.service.BroadcastIntentService

class IntentServiceActivity : BaseActivity() {

    private val responseReceiver by lazy {
        ResponseReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(
                responseReceiver,
                IntentFactory.createLocalBroadcastIntentFilter())
    }

    override fun onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(responseReceiver)
        super.onPause()
    }

    fun onButtonClickListener(view: View) {
        Toast.makeText(this, "You click button", Toast.LENGTH_SHORT).show()
        startService(Intent(this, BroadcastIntentService::class.java))
    }

    private fun setReceiverEnabled() {
        packageManager.setComponentEnabledSetting(ComponentName(this, ResponseReceiver::class.java),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP)
    }

    private fun setReceiverDisabled() {
        packageManager.setComponentEnabledSetting(ComponentName(this, ResponseReceiver::class.java),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP)
    }

    // 在Manifest中将enable属性设置为false,意味着除非应用显示地启用Receiver,否则将不被调用。
    private class ResponseReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show()
        }

    }
}
