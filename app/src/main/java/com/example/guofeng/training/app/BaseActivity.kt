package com.example.guofeng.training.app

import android.support.v7.app.AppCompatActivity

/**
 * Created by guofeng on 2017/12/1.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        App.refWatcher?.watch(this)
    }
}