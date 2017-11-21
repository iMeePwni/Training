package com.example.guofeng.training.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.guofeng.training.R
import com.example.guofeng.training.databinding.ItemViewHolderBinding
import com.example.guofeng.training.model.IntentFactory
import com.example.guofeng.training.vm.ItemViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_view.adapter = Adapter(IntentFactory.creatIntents(this))
    }

    private class ViewHolder(val binding: ItemViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(intent: Intent) {
            binding.viewModel = ItemViewModel(intent)
            binding.executePendingBindings()
        }
    }

    private class Adapter(private var intents: List<Intent>)
        : RecyclerView.Adapter<ViewHolder>() {

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(intents[position])
        }

        override fun getItemCount(): Int {
            return intents.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = DataBindingUtil.inflate<ItemViewHolderBinding>(LayoutInflater.from(parent.context), R.layout.item_view_holder, parent, false)
            return ViewHolder(binding)
        }
    }

}


