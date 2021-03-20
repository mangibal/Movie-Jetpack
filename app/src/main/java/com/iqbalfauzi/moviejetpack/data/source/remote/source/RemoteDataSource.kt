package com.iqbalfauzi.moviejetpack.data.source.remote.source

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieResponse
import com.iqbalfauzi.moviejetpack.data.source.remote.network.ApiService
import com.iqbalfauzi.moviejetpack.data.source.remote.network.helper.DataResult
import com.iqbalfauzi.moviejetpack.data.source.remote.network.helper.callApi

/**
 * Created by Iqbal Fauzi on 3/8/21 2:40 PM
 * iqbal.fauzi.if99@gmail.com
 */
class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getNowPlayingMovies(requestPage: Int): DataResult<MovieResponse> =
        callApi { apiService.getNowPlayingMovie(requestPage) }

    suspend fun getUpcomingMovies(requestPage: Int) =
        callApi { apiService.getUpcomingMovie(requestPage) }

    suspend fun getOnTheAirTv(requestPage: Int) =
        callApi { apiService.getOnTheAirTv(requestPage) }

    suspend fun getPopularTv(requestPage: Int) =
        callApi { apiService.getPopularTvShow(requestPage) }
}