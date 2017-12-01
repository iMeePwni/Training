package com.example.guofeng.training.view.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_basic.*
import kotlinx.android.synthetic.main.content_basic.*
import java.util.*
import kotlin.properties.Delegates

class BasicActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_basic)
        setSupportActionBar(toolbar)

        val strings = arrayListOf(getString(R.string.app_name),
                getString(R.string.title_activity_basic),
                getString(R.string.title_activity_bottom_navigation),
                getString(R.string.title_activity_net_work_operation))
        val adapter = Adapter(strings)

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_view.adapter = adapter

        fab.setOnClickListener { view ->
            Observable.create<String> {
                val element = "Random ${Random().nextInt()}"
                strings.add(element)
                adapter.notifyItemInserted(strings.size - 1)
                it.onNext(element)
                it.onComplete()
            }.subscribe { element ->
                Snackbar.make(view, "You Add $element in strings", Snackbar.LENGTH_LONG)
                        .setAction("Undo", {
                            strings.remove(element)
                            adapter.notifyItemRemoved(strings.size)
                        }).show()
            }
        }
    }

    private class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var text1 by Delegates.notNull<TextView>()

        init {
            text1 = view.findViewById(android.R.id.text1)
        }

        fun bind(data: String) {
            text1.text = data
        }
    }

    private class Adapter(var strings: List<String>) : RecyclerView.Adapter<ViewHolder>() {
        override fun getItemCount() = strings.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(strings[position])
        }

    }
}
