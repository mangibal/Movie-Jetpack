package com.iqbalfauzi.moviejetpack.data.repository.remote

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieResponse
import com.iqbalfauzi.moviejetpack.data.repository.remote.network.ApiService
import com.iqbalfauzi.moviejetpack.data.repository.remote.source.MovieSource
import com.skydoves.sandwich.ApiResponse

/**
 * Created by Iqbal Fauzi on 2/21/21 1:46 PM
 * iqbal.fauzi.if99@gmail.com
 */
class RemoteRepository(private val apiService: ApiService) : MovieSource {

    override suspend fun getNowPlayingMovie(requestPage: Int): ApiResponse<MovieResponse> =
        apiService.getNowPlayingMovie(requestPage)

}