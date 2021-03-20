package com.iqbalfauzi.moviejetpack.domain.repository.usescase

import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.source.DataCallback
import com.iqbalfauzi.moviejetpack.data.source.DataState
import com.iqbalfauzi.moviejetpack.domain.repository.IRepository
import kotlinx.coroutines.flow.collect

/**
 * Created by Iqbal Fauzi on 3/14/21 11:52 AM
 * iqbal.fauzi.if99@gmail.com
 */
class TvShowInteractor(private val repository: IRepository) : TvShowUseCase {

    override suspend fun getOnTheAirTv(
        requestPage: Int,
        dataCallback: DataCallback<List<TvShowEntity>>
    ) {
        repository.getOnTheAirTv(requestPage).collect {
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

    override suspend fun getPopularTv(
        requestPage: Int,
        dataCallback: DataCallback<List<TvShowEntity>>
    ) {
        repository.getPopularTv(requestPage).collect {
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