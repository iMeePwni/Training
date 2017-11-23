package com.example.guofeng.training.app

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by guofeng on 2017/11/23.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance by Delegates.notNull<Application>()
    }
}