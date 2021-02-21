package com.iqbalfauzi.moviejetpack.data.repository

import com.iqbalfauzi.moviejetpack.data.repository.remote.RemoteRepository
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 2/21/21 2:35 PM
 * iqbal.fauzi.if99@gmail.com
 */
val repositoryModule = module {
    factory { RemoteRepository(get()) }
    factory { Repository(get()) }
}