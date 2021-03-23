package com.iqbalfauzi.moviejetpack.presentation.detail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 3/20/21 11:13 AM
 * iqbal.fauzi.if99@gmail.com
 */
val detailModule = module {
    viewModel { DetailViewModel() }
}