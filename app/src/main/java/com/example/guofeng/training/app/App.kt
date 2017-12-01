package com.example.guofeng.training.app

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import kotlin.properties.Delegates

/**
 * Created by guofeng on 2017/11/23.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        initLeakCanary()
    }

    private fun initLeakCanary() {
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            refWatcher = LeakCanary.install(this)
        }
    }

    companion object {
        var instance by Delegates.notNull<Application>()
        var refWatcher: RefWatcher? = null
    }

}