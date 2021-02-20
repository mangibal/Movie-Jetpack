package com.iqbalfauzi.moviejetpack.koin

import com.iqbalfauzi.moviejetpack.presentation.home.module.mainModule
import org.koin.core.module.Module

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
val appComponent: List<Module> = listOf(
    mainModule
)