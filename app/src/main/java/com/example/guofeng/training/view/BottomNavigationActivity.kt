package com.example.guofeng.training.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    message.setText(R.string.title_home)
                }
                R.id.navigation_dashboard -> {
                    message.setText(R.string.title_dashboard)
                }
                R.id.navigation_notifications -> {
                    message.setText(R.string.title_notifications)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
