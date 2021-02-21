package com.iqbalfauzi.moviejetpack.koin

import com.iqbalfauzi.moviejetpack.data.repository.remote.module.networkModule
import com.iqbalfauzi.moviejetpack.data.repository.repositoryModule
import com.iqbalfauzi.moviejetpack.presentation.home.homeModule
import com.iqbalfauzi.moviejetpack.presentation.main.module.mainModule
import org.koin.core.module.Module

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
val appComponent: List<Module> = listOf(
    /**
     * Data Module
     * */
    networkModule,
    repositoryModule,
    /**
     * Presentation Module
     * */
    mainModule,
    homeModule
)