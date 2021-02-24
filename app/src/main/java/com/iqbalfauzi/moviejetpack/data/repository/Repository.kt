package com.iqbalfauzi.moviejetpack.data.repository

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.repository.remote.RemoteRepository
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Iqbal Fauzi on 2/21/21 1:55 PM
 * iqbal.fauzi.if99@gmail.com
 */
class Repository(private val remoteRepository: RemoteRepository) {

    suspend fun getNowPlayingMovie(page: Int = 1, dataCallback: DataCallback<List<MovieEntity>>) =
        flow {
            var movies: List<MovieEntity>
            val response = remoteRepository.getNowPlayingMovie(page)

            /**
             * emit from local storage first
             * fetch from local here
             * */

            // On Success Callback
            response.suspendOnSuccess {
                if (data != null) {
                    movies = data?.results ?: emptyList()
                    emit(movies)
                    dataCallback.onSuccess(movies)
                }
            }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
                .onError {
                    dataCallback.onError(message())
                }
                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
                .onException {
                    dataCallback.onException(message())
                }
        }.flowOn(Dispatchers.IO).collect()

    suspend fun getUpcomingMovie(page: Int = 1, dataCallback: DataCallback<List<MovieEntity>>) =
        flow {
            var movies: List<MovieEntity>
            val response = remoteRepository.getUpcomingMovie(page)
            /**
             * emit from local storage first
             * */

            // On Success Callback
            response.suspendOnSuccess {
                if (data != null) {
                    movies = data?.results ?: emptyList()
                    emit(movies)
                    dataCallback.onSuccess(movies)
                }
            }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
                .onError {
                    dataCallback.onError(message())
                }
                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
                .onException {
                    dataCallback.onException(message())
                }
        }.flowOn(Dispatchers.IO).collect()

    suspend fun getOnTheAirTv(page: Int = 1, dataCallback: DataCallback<List<TvShowEntity>>) =
        flow {
            var tvShows: List<TvShowEntity>
            val response = remoteRepository.getOnTheAirTv(page)
            /**
             * emit from local storage first
             * */

            // On Success Callback
            response.suspendOnSuccess {
                if (data != null) {
                    tvShows = data?.result ?: emptyList()
                    emit(tvShows)
                    dataCallback.onSuccess(tvShows)
                }
            }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
                .onError {
                    dataCallback.onError(message())
                }
                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
                .onException {
                    dataCallback.onException(message())
                }
        }.flowOn(Dispatchers.IO).collect()

    suspend fun getPopularTvShow(page: Int = 1, dataCallback: DataCallback<List<TvShowEntity>>) =
        flow {
            var tvShows: List<TvShowEntity>
            val response = remoteRepository.getPopularTv(page)
            /**
             * emit from local storage first
             * */

            // On Success Callback
            response.suspendOnSuccess {
                if (data != null) {
                    tvShows = data?.result ?: emptyList()
                    emit(tvShows)
                    dataCallback.onSuccess(tvShows)
                }
            }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
                .onError {
                    dataCallback.onError(message())
                }
                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
                .onException {
                    dataCallback.onException(message())
                }
        }.flowOn(Dispatchers.IO).collect()

}