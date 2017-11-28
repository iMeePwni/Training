package com.example.guofeng.training.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.activity_deep_linking.*

class DeepLinkingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_linking)

        url.text = intent.data.host
    }
}
