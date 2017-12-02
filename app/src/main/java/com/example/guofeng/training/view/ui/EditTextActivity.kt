package com.example.guofeng.training.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        phone.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == phone.imeActionId) {
                Toast.makeText(this, "You search ${v.text.trim()}", Toast.LENGTH_SHORT).show()
                true
            } else {
                false
            }
        }
    }
}
