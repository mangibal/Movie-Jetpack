package com.iqbalfauzi.moviejetpack.external.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Iqbal Fauzi on 21/02/21 11.54
 * iqbal.fauzi.if99@gmail.com
 */
fun Activity.initRecyclerViewList(rv: RecyclerView, isVertical: Boolean = true) {
    val rvLayoutManager = if (isVertical) {
        LinearLayoutManager(
            this@initRecyclerViewList,
            LinearLayoutManager.VERTICAL,
            false
        )
    } else {
        LinearLayoutManager(
            this@initRecyclerViewList,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }

    rv.apply {
        setHasFixedSize(true)
        layoutManager = rvLayoutManager
        itemAnimator = DefaultItemAnimator()
    }
}

@Suppress("DEPRECATION")
fun Activity.makeStatusBarTransparent() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            statusBarColor = Color.TRANSPARENT
        }
    }
}

fun View.setMarginTop(marginTop: Int) {
    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    menuLayoutParams.setMargins(0, marginTop, 0, 0)
    this.layoutParams = menuLayoutParams
}

fun View.show(isShow: Boolean = true) {
    visibility = if (isShow) View.VISIBLE else View.GONE
}

fun Context.toast(message: String, time: TIME = TIME.SHORT, position: POSITION = POSITION.BOTTOM) {
    when {
        time == TIME.SHORT && position == POSITION.BOTTOM -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 24)
            toast.show()
        }
        time == TIME.LONG && position == POSITION.BOTTOM -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            toast.show()
        }
        time == TIME.SHORT && position == POSITION.CENTER -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        time == TIME.SHORT && position == POSITION.TOP -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
        time == TIME.LONG && position == POSITION.CENTER -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        else -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
    }
}

enum class TIME {
    SHORT,
    LONG
}

enum class POSITION {
    BOTTOM,
    CENTER,
    TOP
}