package com.example.guofeng.training.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guofeng.training.R
import com.example.guofeng.training.app.App

class LeakCanaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_canary)

        App.leakedActivity = this
    }
}
