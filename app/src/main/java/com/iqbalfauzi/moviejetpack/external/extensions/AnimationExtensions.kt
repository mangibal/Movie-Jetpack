package com.iqbalfauzi.moviejetpack.external.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.core.view.isVisible

/**
 * Created by Iqbal Fauzi on 2/25/21 9:59 AM
 * iqbal.fauzi.if99@gmail.com
 */
fun View.toggleFade(duration: Long) {
    if (this.isVisible) {
        this.animate()
            .alpha(0.0f)
            .setDuration(duration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    this@toggleFade.show(false)
                }
            })
    } else {
        this.animate()
            .alpha(1.0f)
            .setDuration(duration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    super.onAnimationStart(animation)
                    this@toggleFade.show()
                }
            })
    }
}

fun View.startFade(duration: Long) {
    this.animate()
        .alpha(1.0f)
        .setDuration(duration)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                this@startFade.show(true)
            }
        })
}