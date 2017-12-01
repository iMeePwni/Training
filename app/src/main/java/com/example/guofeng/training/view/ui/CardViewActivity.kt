package com.example.guofeng.training.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.activity_card_view.*

class CardViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        switchTest.setOnCheckedChangeListener { view, isChecked ->
            Toast.makeText(this, "$view isChecked: $isChecked", Toast.LENGTH_SHORT).show()
        }
        switchTest.isChecked = true
    }
}
