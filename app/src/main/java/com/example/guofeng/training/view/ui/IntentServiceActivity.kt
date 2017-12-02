package com.example.guofeng.training.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import com.example.guofeng.training.model.service.BroadcastIntentService

class IntentServiceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)
    }

    fun onButtonClickListener(view: View) {
        Toast.makeText(this, "You click button", Toast.LENGTH_SHORT).show()
        startService(Intent(this, BroadcastIntentService::class.java))
    }
}
