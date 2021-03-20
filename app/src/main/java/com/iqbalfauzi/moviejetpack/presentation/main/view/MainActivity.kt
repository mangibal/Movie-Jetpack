package com.iqbalfauzi.moviejetpack.presentation.main.view

import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iqbalfauzi.moviejetpack.R
import com.iqbalfauzi.moviejetpack.databinding.ActivityMainBinding
import com.iqbalfauzi.moviejetpack.domain.base.view.BaseActivity
import com.iqbalfauzi.moviejetpack.external.extensions.isLowRamDevice
import com.iqbalfauzi.moviejetpack.external.extensions.makeStatusBarTransparent
import com.iqbalfauzi.moviejetpack.external.extensions.toast
import com.iqbalfauzi.moviejetpack.presentation.main.adapter.MainNavigationAdapter
import com.iqbalfauzi.moviejetpack.presentation.main.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
@KoinApiExtension
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    MainViewModel::class,
    ActivityMainBinding::inflate
) {

    private var doubleTapExit = false

    private val mainNavigationAdapter: MainNavigationAdapter by lazy {
        return@lazy MainNavigationAdapter(this)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            with(binding) {
                when (item.itemId) {
                    R.id.nav_home -> vpContent.setCurrentItem(0, false)
                    R.id.nav_saved -> vpContent.setCurrentItem(1, false)
                    R.id.nav_profile -> vpContent.setCurrentItem(2, false)
                }
            }
            true
        }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupBottomNavigation()
        makeStatusBarTransparent()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            insets.consumeSystemWindowInsets()
        }
    }

    private fun setupBottomNavigation() {
        with(binding) {
            vpContent.apply {
                offscreenPageLimit = if (isLowRamDevice()) 1 else ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
                isUserInputEnabled = false
                adapter = mainNavigationAdapter
            }
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        }
    }

    override fun onBackPressed() {
        if (doubleTapExit) {
            super.onBackPressed()
            return
        }

        doubleTapExit = true
        toast(getString(R.string.msg_press_again_to_exit))

        // return to normal state
        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                doubleTapExit = false
            }
        }
    }

}