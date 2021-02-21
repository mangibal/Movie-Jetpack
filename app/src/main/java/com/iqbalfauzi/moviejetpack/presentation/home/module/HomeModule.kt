package com.iqbalfauzi.moviejetpack.presentation.home

import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 2/21/21 2:31 PM
 * iqbal.fauzi.if99@gmail.com
 */
val homeModule = module {
    viewModel { HomeViewModel() }
}