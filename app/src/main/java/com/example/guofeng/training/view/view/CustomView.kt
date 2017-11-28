package com.example.guofeng.training.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.view_custom_view.view.*

/**
 * Created by guofeng on 2017/11/28.
 */
class CustomView : LinearLayout {


    constructor(context: Context) : super(context) {
        inflateView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inflateView()
        initAttrs(context, attrs)

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inflateView()
        initAttrs(context, attrs)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet) {
        with(context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)) {
            try {
                image_view.setImageResource(getResourceId(R.styleable.CustomView_src, R.mipmap.ic_launcher_round))
                text_view.text = getString(R.styleable.CustomView_text)
            } finally {
                recycle()
            }
        }
    }


    private fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.view_custom_view, this)
    }

}