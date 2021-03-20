package com.iqbalfauzi.moviejetpack.koin

import com.iqbalfauzi.moviejetpack.data.source.local.module.databaseModule
import com.iqbalfauzi.moviejetpack.data.source.remote.module.networkModule
import com.iqbalfauzi.moviejetpack.domain.repository.module.repositoryModule
import com.iqbalfauzi.moviejetpack.domain.repository.module.useCaseModule
import com.iqbalfauzi.moviejetpack.external.logger.loggerModule
import com.iqbalfauzi.moviejetpack.presentation.home.module.homeModule
import com.iqbalfauzi.moviejetpack.presentation.main.module.mainModule
import org.koin.core.module.Module

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
val appComponent: List<Module> = listOf(
    /**
     * App Level Module
     * */
    loggerModule,
    /**
     * Data Module
     * */
    databaseModule,
    networkModule,
    repositoryModule,
    useCaseModule,
    /**
     * Presentation Module
     * */
    mainModule,
    homeModule
)