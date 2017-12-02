package com.example.guofeng.training.app

import android.support.v7.app.AppCompatActivity

/**
 * Created by guofeng on 2017/12/1.
 */
open class BaseActivity : AppCompatActivity() {

    protected val tag : String by lazy {
        javaClass.simpleName
    }

    override fun onDestroy() {
        super.onDestroy()
        App.refWatcher?.watch(this)
    }
}