package com.example.guofeng.training.view.ui

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import android.util.Log
import android.view.WindowManager
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity

class CursorLoaderActivity : BaseActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    override fun onLoaderReset(loader: Loader<Cursor>?) {

    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        return CursorLoader(this, uri, projection, null, null, null)
    }

    override fun onLoadFinished(loader: Loader<Cursor>?, data: Cursor?) {
        while (data != null && data.moveToNext()) {
            Log.d(tag, data.getString(0))
        }
        Log.d(tag, "load finished")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursor_loader)

        // 屏幕常亮Flag 最好在代码中实现 动态添加和取消
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
//        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportLoaderManager.initLoader(R.id.loader_local_cursor, null, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        supportLoaderManager.destroyLoader(R.id.loader_local_cursor)
    }
}
