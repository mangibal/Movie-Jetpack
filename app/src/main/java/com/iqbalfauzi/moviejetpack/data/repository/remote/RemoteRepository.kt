package com.iqbalfauzi.moviejetpack.data.repository.remote

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieResponse
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowResponse
import com.iqbalfauzi.moviejetpack.data.repository.remote.network.ApiService
import com.iqbalfauzi.moviejetpack.data.repository.remote.source.RemoteSource
import com.skydoves.sandwich.ApiResponse

/**
 * Created by Iqbal Fauzi on 2/21/21 1:46 PM
 * iqbal.fauzi.if99@gmail.com
 */
class RemoteRepository(private val apiService: ApiService) : RemoteSource {

    override suspend fun getNowPlayingMovie(requestPage: Int): ApiResponse<MovieResponse> =
        apiService.getNowPlayingMovie(requestPage)

    override suspend fun getUpcomingMovie(requestPage: Int): ApiResponse<MovieResponse> =
        apiService.getUpcomingMovie(requestPage)

    override suspend fun getOnTheAirTv(requestPage: Int): ApiResponse<TvShowResponse> =
        apiService.getOnTheAirTv(requestPage)

    override suspend fun getPopularTv(requestPage: Int): ApiResponse<TvShowResponse> =
        apiService.getPopularTvShow(requestPage)

}