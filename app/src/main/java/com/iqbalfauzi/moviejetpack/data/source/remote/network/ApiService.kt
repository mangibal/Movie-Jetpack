package com.iqbalfauzi.moviejetpack.data.source.remote.network

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieResponse
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Iqbal Fauzi on 2/21/21 1:35 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface ApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(@Query("page") requestPage: Int): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("page") requestPage: Int): MovieResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTv(@Query("page") requestPage: Int): TvShowResponse

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("page") requestPage: Int): TvShowResponse

//    @GET("movie/{movie_id}")
//    suspend fun getMovie(@Path("movie_id") movieId: Int): ApiResponse<Movie>
}