package com.example.guofeng.training.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import com.example.guofeng.training.model.data.DictionaryItem
import com.example.guofeng.training.model.db.DatabaseOpenHelper

class SearchResultActivity : BaseActivity() {

    private val db by lazy {
        DatabaseOpenHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val query = intent.getStringExtra(KEY_QUERY)
        val cursor = db.getWordMatches(query, arrayOf(DictionaryItem.KEY_WORD, DictionaryItem.KEY_DEFINITION))
        cursor?.let {
            it.moveToFirst()
            Log.d("handleIntent",
                    "${it.getColumnName(0)}:${it.getString(0)}  ${it.getColumnName(1)}:${it.getColumnName(1)}")
        }
    }

    companion object {
        private val KEY_QUERY = "query"

        fun startActivity(context: Context, query: String) {
            val intent = Intent(context, SearchResultActivity::class.java)
            intent.putExtra(KEY_QUERY, query)
            context.startActivity(intent)
        }
    }
}
