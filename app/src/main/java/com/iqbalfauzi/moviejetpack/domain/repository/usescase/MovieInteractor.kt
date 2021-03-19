package com.iqbalfauzi.moviejetpack.domain.repository.usescase

import com.iqbalfauzi.moviejetpack.data.source.DataState
import com.iqbalfauzi.moviejetpack.domain.repository.IRepository
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.source.DataCallback
import kotlinx.coroutines.flow.collect

/**
 * Created by Iqbal Fauzi on 3/14/21 11:52 AM
 * iqbal.fauzi.if99@gmail.com
 */
class MovieInteractor(private val repository: IRepository) : MovieUseCase {

    override suspend fun getNowPlayingMovie(
        requestPage: Int,
        dataCallback: DataCallback<List<MovieEntity>>
    ) {
        repository.getNowPlayingMovie(requestPage).collect {
            when (it) {
                is DataState.Success -> {
                    dataCallback.onSuccess(it.data ?: emptyList())
                }
                is DataState.Error -> {
                    dataCallback.onError(it.throwable ?: Throwable("Something went wrong"))
                }
            }
        }
    }

    override suspend fun getUpcomingMovie(
        requestPage: Int,
        dataCallback: DataCallback<List<MovieEntity>>
    ) {
        repository.getUpcomingMovie(requestPage).collect {
            when (it) {
                is DataState.Success -> {
                    dataCallback.onSuccess(it.data ?: emptyList())
                }
                is DataState.Error -> {
                    dataCallback.onError(it.throwable ?: Throwable("Something went wrong"))
                }
            }
        }
    }

}