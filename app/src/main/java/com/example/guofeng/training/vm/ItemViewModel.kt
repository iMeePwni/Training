package com.example.guofeng.training.vm

import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
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
        view.context.startActivity(intent)
    }
}