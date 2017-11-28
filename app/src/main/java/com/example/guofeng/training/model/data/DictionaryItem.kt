package com.example.guofeng.training.model.data

import android.content.ContentValues

/**
 * Created by guofeng on 2017/11/28.
 */
data class DictionaryItem(
        var word: String,
        var definition: String) {

    fun toContentValue() = ContentValues().apply {
        put(KEY_WORD, word)
        put(KEY_DEFINITION, definition)
    }

    companion object {
        val KEY_WORD = "word"
        val KEY_DEFINITION = "definition"
    }
}