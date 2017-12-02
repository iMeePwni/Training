package com.example.guofeng.training.view.ui

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.guofeng.training.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_palette.*
import kotlin.properties.Delegates

class PaletteActivity : AppCompatActivity() {

    private val pairs = mutableListOf<Pair<String, Int?>>()
    private val adapter = Adapter(pairs)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        recycler_view.layoutManager = StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.HORIZONTAL)
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recycler_view.adapter = adapter

        Picasso.with(this)
                .load("https://img.gcall.com/dca3/M00/13/67/wKhoMFofuz-EQVZTAAAAAAAAAAA730.jpg?size=400x254")
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        showPaletteColor()
                    }

                    override fun onError() {
                        //
                    }

                })

        apply.setOnClickListener {
            if (pairs.size != 0) {
                val typedValue = TypedValue()
                theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
            }
        }
    }

    private fun showPaletteColor() {
        pairs.clear()
        val bitmapDrawable = imageView.drawable as BitmapDrawable
        val palette = Palette.from(bitmapDrawable.bitmap).generate()
        pairs.add(Pair("亮色", palette.vibrantSwatch?.rgb))
        pairs.add(Pair("深亮色", palette.darkVibrantSwatch?.rgb))
        pairs.add(Pair("浅亮色", palette.lightVibrantSwatch?.rgb))
        pairs.add(Pair("暗色", palette.mutedSwatch?.rgb))
        pairs.add(Pair("深暗色", palette.darkMutedSwatch?.rgb))
        pairs.add(Pair("浅暗色", palette.lightMutedSwatch?.rgb))
        adapter.notifyDataSetChanged()
    }

    private class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var text1 by Delegates.notNull<TextView>()

        init {
            text1 = view.findViewById(android.R.id.text1)
        }

        fun bind(pair: Pair<String, Int?>) {
            text1.text = pair.first
            text1.setBackgroundColor(pair.second ?: 0)
        }
    }

    private class Adapter(var pairs: List<Pair<String, Int?>>) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(android.R.layout.simple_list_item_1, parent, false))
        }

        override fun getItemCount(): Int {
            return pairs.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(pairs[position])
        }

    }
}
