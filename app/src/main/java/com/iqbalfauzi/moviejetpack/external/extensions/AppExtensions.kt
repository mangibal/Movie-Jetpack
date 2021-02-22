package com.iqbalfauzi.moviejetpack.external.extensions

import android.app.ActivityManager
import android.content.Context

/**
 * Created by Iqbal Fauzi on 21/02/21 11.51
 * iqbal.fauzi.if99@gmail.com
 */
fun Context.isLowRamDevice(): Boolean =
    (this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).isLowRamDevice