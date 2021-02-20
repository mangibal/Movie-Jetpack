package com.iqbalfauzi.moviejetpack.presentation.home.module

import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 20/02/21 18.06
 * iqbal.fauzi.if99@gmail.com
 */
val mainModule = module {
    viewModel { MainViewModel() }
}