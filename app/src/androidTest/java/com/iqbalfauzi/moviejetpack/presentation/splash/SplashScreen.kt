package com.iqbalfauzi.moviejetpack.presentation.splash

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.text.KTextView
import com.iqbalfauzi.moviejetpack.R
import com.kaspersky.kaspresso.screens.KScreen

/**
 * Created by Iqbal Fauzi on 2/20/21 10:24 PM
 * iqbal.fauzi.if99@gmail.com
 */
object SplashScreen : KScreen<SplashScreen>() {

    override val layoutId: Int
        get() = R.layout.activity_splash
    override val viewClass: Class<*>
        get() = SplashActivity::class.java

    val ivAppIcon = KImageView { withId(R.id.iv_app_logo)}

    val tvTitleApp = KTextView { withId(R.id.tv_app_title)}

}