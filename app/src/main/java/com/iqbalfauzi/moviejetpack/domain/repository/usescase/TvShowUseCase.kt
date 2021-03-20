package com.iqbalfauzi.moviejetpack.domain.repository.usescase

import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.source.DataCallback

/**
 * Created by Iqbal Fauzi on 3/14/21 11:53 AM
 * iqbal.fauzi.if99@gmail.com
 */
interface TvShowUseCase {
    suspend fun getOnTheAirTv(requestPage: Int, dataCallback: DataCallback<List<TvShowEntity>>)
    suspend fun getPopularTv(requestPage: Int, dataCallback: DataCallback<List<TvShowEntity>>)
}