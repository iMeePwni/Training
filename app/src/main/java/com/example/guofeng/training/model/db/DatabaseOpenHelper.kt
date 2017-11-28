package com.example.guofeng.training.model.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.util.Log
import com.example.guofeng.training.model.data.DictionaryItem
import com.example.guofeng.training.model.lab.DictionaryItemLab

/**
 * Created by guofeng on 2017/11/28.
 */
class DatabaseOpenHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(FTS_TABLE_CREATE)
        loadDictionary(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.w(TAG, "Upgrading database from version $oldVersion to $newVersion, which will destroy all old data")
        db.execSQL("DROP TABLE IF EXISTS $FTS_VIRTUAL_TABLE")
    }

    private fun loadDictionary(db: SQLiteDatabase) {

        fun addWord(dictionaryItem: DictionaryItem) = db.insert(FTS_VIRTUAL_TABLE,
                null,
                dictionaryItem.toContentValue())

        DictionaryItemLab.createDictionaryItemList().forEach {
            val id = addWord(it)
            if (id < 0) {
                Log.e(TAG, "unable to add word: $it")
            }
        }

    }

    fun getWordMatches(query: String, columns: Array<String>?): Cursor? {
        val selection = "${DictionaryItem.KEY_WORD} MATCH ?"
        val selectionArgs = arrayOf("$query*")
        return query(selection, selectionArgs, columns)
    }

    private fun query(selection: String, selectionArgs: Array<String>, columns: Array<String>?): Cursor? {
        val queryBuilder = SQLiteQueryBuilder()
        queryBuilder.tables = FTS_VIRTUAL_TABLE
        val cursor = queryBuilder.query(this.readableDatabase, columns, selection, selectionArgs, null, null, null)
        return when {
            cursor == null -> null
            !cursor.moveToFirst() -> {
                cursor.close()
                null
            }
            else -> cursor
        }
    }

    companion object {
        val TAG = DatabaseOpenHelper::class.java.simpleName!!
        private val DB_NAME = "dictionary"
        private val DB_VERSION = 1
        private val FTS_VIRTUAL_TABLE = "FTS"

        private val FTS_TABLE_CREATE =
                "CREATE VIRTUAL TABLE $FTS_VIRTUAL_TABLE USING fts3 (${DictionaryItem.KEY_WORD}, ${DictionaryItem.KEY_DEFINITION})"
    }
}