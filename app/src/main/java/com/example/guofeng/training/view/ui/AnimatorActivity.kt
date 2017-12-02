package com.example.guofeng.training.view.ui

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.example.guofeng.training.R
import com.example.guofeng.training.app.BaseActivity
import kotlinx.android.synthetic.main.activity_animator.*

class AnimatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)

        val path = Path()
        path.lineTo(window.decorView.width + 0.0f, window.decorView.height + 0.0f)
        val objectAnimator = ObjectAnimator.ofFloat(imageView, View.X, View.Y, path)
        object_animator.setOnClickListener {
            objectAnimator.start()
        }
        val detector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent?): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                super.onLongPress(e)
                Log.d(tag, "onLongPress")
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                Log.d(tag, "onFling")
                return super.onFling(e1, e2, velocityX, velocityY)
            }
        })
        detector.setOnDoubleTapListener(object : GestureDetector.OnDoubleTapListener{
            override fun onDoubleTap(e: MotionEvent?): Boolean {
                Log.d(tag, "onDoubleTap $e")
                return true
            }

            override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                Log.d(tag, "onDoubleTapEvent $e")
                return true
            }

            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                Log.d(tag, "onSingleTapConfirmed $e")
                return true
            }

        })
        cardView.setOnTouchListener { _, event ->
            val result = detector.onTouchEvent(event)
            if (!result) {
                return@setOnTouchListener super.onTouchEvent(event)
            }
            result
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(tag, "Event action: ACTION_DOWN")
                true
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d(tag, "Event action: ACTION_MOVE")
                true
            }
            MotionEvent.ACTION_UP -> {
                Log.d(tag, "Event action: ACTION_UP")
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d(tag, "Event action: ACTION_CANCEL")
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d(tag, "Event action: ACTION_OUTSIDE")
                true
            }
            else -> super.onTouchEvent(event)
        }

    }
}
