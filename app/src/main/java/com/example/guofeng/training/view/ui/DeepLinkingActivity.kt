package com.example.guofeng.training.view.ui

import android.os.Bundle
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import kotlinx.android.synthetic.main.activity_deep_linking.*

class DeepLinkingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_linking)

        url.text = intent.data.host
    }
}
