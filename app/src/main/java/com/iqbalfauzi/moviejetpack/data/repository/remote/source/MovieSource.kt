package com.iqbalfauzi.moviejetpack.data.repository.remote.source

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieResponse
import com.skydoves.sandwich.ApiResponse

/**
 * Created by Iqbal Fauzi on 2/21/21 1:41 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface MovieSource {
    suspend fun getNowPlayingMovie(requestPage: Int = 1): ApiResponse<MovieResponse>
    suspend fun getUpcomingMovie(requestPage: Int = 1): ApiResponse<MovieResponse>
}