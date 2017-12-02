package com.example.guofeng.training.vm

import android.app.Activity
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.app.ActivityOptionsCompat
import android.view.View

/**
 * Created by guofeng on 2017/11/21.
 */
class ItemViewModel(private var intent: Intent) : BaseObservable() {

    @Bindable
    fun getName(): String {
        val split = intent.component.shortClassName.split(".")
        return split[split.size - 1]
    }

    fun onItemClick(view: View) {
        val activity = view.context as Activity
//        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, Pair(view, activity.getString(R.string.transition_name))).toBundle())
        activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle())
    }
}