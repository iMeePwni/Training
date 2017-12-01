package com.example.guofeng.training.app

import android.app.Activity
import android.app.Application
import com.example.guofeng.training.BuildConfig
import com.example.guofeng.training.model.service.LeakService
import com.squareup.leakcanary.AndroidExcludedRefs
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
            refWatcher = getRefWatcher()
        }
    }

    private fun getRefWatcher(): RefWatcher? {
        return if (BuildConfig.DEBUG) {
            LeakCanary.refWatcher(this)
                    .listenerServiceClass(LeakService::class.java)
                    .excludedRefs(AndroidExcludedRefs.createAppDefaults().build())
                    .buildAndInstall()
        } else {
            RefWatcher.DISABLED
        }

    }

    companion object {
        var instance by Delegates.notNull<Application>()
        var refWatcher: RefWatcher? = null
        var leakedActivity: Activity? = null
    }

}