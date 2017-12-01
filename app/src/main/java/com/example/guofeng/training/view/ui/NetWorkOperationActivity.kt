package com.example.guofeng.training.view.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity

class NetWorkOperationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net_work_operation)

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

    }
}
