package com.iqbalfauzi.moviejetpack.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.iqbalfauzi.moviejetpack.databinding.ActivitySplashBinding
import com.iqbalfauzi.moviejetpack.domain.base.view.BaseActivity
import com.iqbalfauzi.moviejetpack.domain.router.ScreenRouter
import com.iqbalfauzi.moviejetpack.presentation.home.view.MainActivity
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
class SplashActivity : BaseActivity<MainViewModel, ActivitySplashBinding>(
    MainViewModel::class,
    ActivitySplashBinding::inflate
) {

    override fun onInitUI(savedInstanceState: Bundle?) {
        hideSystemUI()
        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                ScreenRouter.goToActivityClearStack(this@SplashActivity, MainActivity::class.java)
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

}