package com.iqbalfauzi.moviejetpack.domain.repository.usescase

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.source.DataCallback

/**
 * Created by Iqbal Fauzi on 3/14/21 11:53 AM
 * iqbal.fauzi.if99@gmail.com
 */
interface MovieUseCase {
    suspend fun getNowPlayingMovie(requestPage: Int, dataCallback: DataCallback<List<MovieEntity>>)
    suspend fun getUpcomingMovie(requestPage: Int, dataCallback: DataCallback<List<MovieEntity>>)
}