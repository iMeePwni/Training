package com.example.guofeng.training.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.guofeng.training.R
import kotlinx.android.synthetic.main.view_custom_view.view.*
import kotlin.properties.Delegates

/**
 * Created by guofeng on 2017/11/28.
 */
class CustomView : LinearLayout {

    private var mDetector by Delegates.notNull<GestureDetector>()

    constructor(context: Context) : super(context) {
        inflateView()
        initDetector(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inflateView()
        initAttrs(context, attrs)
        initDetector(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inflateView()
        initAttrs(context, attrs)
        initDetector(context)
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

    private fun initDetector(context: Context) {
        mDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent?): Boolean = true

            override fun onLongPress(e: MotionEvent?) {
                super.onLongPress(e)
                Toast.makeText(context, "YOU PRESS ME TOO LONG", Toast.LENGTH_SHORT).show()
            }

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                visibility = View.INVISIBLE
                return super.onFling(e1, e2, velocityX, velocityY)
            }

        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var result = mDetector.onTouchEvent(event)
        if (!result) {
            if (MotionEvent.ACTION_DOWN == event.action) {
                performClick()
            }
            result = super.onTouchEvent(event)
        }
        return result
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}