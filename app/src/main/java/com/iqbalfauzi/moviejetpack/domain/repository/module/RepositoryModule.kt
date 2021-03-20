package com.iqbalfauzi.moviejetpack.domain.repository.module

import com.iqbalfauzi.moviejetpack.domain.repository.IRepository
import com.iqbalfauzi.moviejetpack.domain.repository.Repository
import com.iqbalfauzi.moviejetpack.data.source.local.LocalDataSource
import com.iqbalfauzi.moviejetpack.data.source.remote.source.RemoteDataSource
import com.iqbalfauzi.moviejetpack.domain.repository.usescase.MovieInteractor
import com.iqbalfauzi.moviejetpack.domain.repository.usescase.MovieUseCase
import com.iqbalfauzi.moviejetpack.domain.repository.usescase.TvShowInteractor
import com.iqbalfauzi.moviejetpack.domain.repository.usescase.TvShowUseCase
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 2/21/21 2:35 PM
 * iqbal.fauzi.if99@gmail.com
 */
val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
    factory<TvShowUseCase> { TvShowInteractor(get()) }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }

    single<IRepository> {
        Repository(get())
    }
}