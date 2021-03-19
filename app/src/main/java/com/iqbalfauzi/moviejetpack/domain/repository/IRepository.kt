package com.iqbalfauzi.moviejetpack.domain.repository

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.source.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by Iqbal Fauzi on 3/8/21 2:51 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface IRepository {
    fun getNowPlayingMovie(requestPage: Int): Flow<DataState<List<MovieEntity>>>
    fun getUpcomingMovie(requestPage: Int): Flow<DataState<List<MovieEntity>>>
    fun getOnTheAirTv(requestPage: Int): Flow<DataState<List<TvShowEntity>>>
    fun getPopularTv(requestPage: Int): Flow<DataState<List<TvShowEntity>>>
}