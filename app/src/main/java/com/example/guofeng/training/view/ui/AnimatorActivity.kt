package com.example.guofeng.training.view.ui

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.animation.PathInterpolator
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
        objectAnimator.interpolator = PathInterpolator(path)
        object_animator.setOnClickListener {
            objectAnimator.start()
        }
    }
}
