package com.iqbalfauzi.moviejetpack.presentation.home.view

import android.os.Bundle
import com.iqbalfauzi.moviejetpack.R
import com.iqbalfauzi.moviejetpack.databinding.ActivityMainBinding
import com.iqbalfauzi.moviejetpack.domain.base.view.BaseActivity
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.MainViewModel

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    MainViewModel::class,
    ActivityMainBinding::inflate
) {

    override fun onInitUI(savedInstanceState: Bundle?) {
        binding.tvSample.text = getString(R.string.app_name)
    }
}