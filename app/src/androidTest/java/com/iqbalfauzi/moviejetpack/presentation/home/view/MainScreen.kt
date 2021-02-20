package com.iqbalfauzi.moviejetpack.presentation.home.view

import com.agoda.kakao.text.KTextView
import com.iqbalfauzi.moviejetpack.R
import com.kaspersky.kaspresso.screens.KScreen

/**
 * Created by Iqbal Fauzi on 2/20/21 10:48 PM
 * iqbal.fauzi.if99@gmail.com
 */
object MainScreen: KScreen<MainScreen>() {
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val tvAppTitle = KTextView { withId(R.id.tv_sample)}

}