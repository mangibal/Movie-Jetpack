package com.iqbalfauzi.moviejetpack.domain.repository

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.source.DataState
import com.iqbalfauzi.moviejetpack.data.source.remote.source.RemoteDataSource
import com.iqbalfauzi.moviejetpack.data.source.remote.network.helper.DataResult
import com.iqbalfauzi.moviejetpack.external.extensions.flowOnBack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Iqbal Fauzi on 3/8/21 2:50 PM
 * iqbal.fauzi.if99@gmail.com
 */
class Repository(
//    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IRepository {

    override fun getNowPlayingMovie(requestPage: Int): Flow<DataState<List<MovieEntity>>> = flow {
        when (val response = remoteDataSource.getNowPlayingMovies(requestPage)) {
            is DataResult.Success -> emit(DataState.Success(response.data.results))
            is DataResult.Failure -> emit(DataState.Error(throwable = response.ex, data = null))
        }
    }.flowOnBack()

    override fun getUpcomingMovie(requestPage: Int): Flow<DataState<List<MovieEntity>>> = flow {
        when (val response = remoteDataSource.getUpcomingMovies(requestPage)) {
            is DataResult.Success -> emit(DataState.Success(response.data.results))
            is DataResult.Failure -> emit(DataState.Error(throwable = response.ex, data = null))
        }
    }.flowOnBack()

    override fun getOnTheAirTv(requestPage: Int): Flow<DataState<List<TvShowEntity>>> = flow {
        when (val response = remoteDataSource.getOnTheAirTv(requestPage)) {
            is DataResult.Success -> emit(DataState.Success(response.data.result))
            is DataResult.Failure -> emit(DataState.Error(throwable = response.ex, data = null))
        }
    }.flowOnBack()

    override fun getPopularTv(requestPage: Int): Flow<DataState<List<TvShowEntity>>> = flow {
        when (val response = remoteDataSource.getPopularTv(requestPage)) {
            is DataResult.Success -> emit(DataState.Success(response.data.result))
            is DataResult.Failure -> emit(DataState.Error(throwable = response.ex, data = null))
        }
    }.flowOnBack()

}