package com.example.guofeng.training.view.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import com.example.guofeng.training.databinding.ActivityNotificationBinding
import com.example.guofeng.training.vm.NotificationViewModel

class NotificationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityNotificationBinding>(this, R.layout.activity_notification)
        binding.viewModel = NotificationViewModel()
    }
}
