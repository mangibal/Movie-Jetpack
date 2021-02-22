package com.iqbalfauzi.moviejetpack.external.logger

import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 2/22/21 9:18 AM
 * iqbal.fauzi.if99@gmail.com
 */
val loggerModule = module {
    single { AppLogger.init() }
}