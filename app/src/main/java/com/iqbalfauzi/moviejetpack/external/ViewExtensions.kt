package com.iqbalfauzi.moviejetpack.external

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast

/**
 * Created by Iqbal Fauzi on 21/02/21 11.54
 * iqbal.fauzi.if99@gmail.com
 */

fun View.show(isShow: Boolean = true) {
    visibility = if (isShow) View.VISIBLE else View.GONE
}

fun Context.toast(message: String, time: Int = 0, position: Int = 0) {
    /*
    * time is duration of toast 0 = short and 1 = long
    * position 0 = default/bottom, 1 = center, 2 = top
    * */
    when {
        time == 0 && position == 0 -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 24)
            toast.show()
        }
        time == 1 && position == 0 -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            toast.show()
        }
        time == 0 && position == 1 -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        time == 0 && position == 2 -> {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
        time == 1 && position == 1 -> {
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