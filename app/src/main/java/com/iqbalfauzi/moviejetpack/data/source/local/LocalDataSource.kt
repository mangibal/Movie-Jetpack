package com.iqbalfauzi.moviejetpack.data.source.local

import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.source.local.dao.MovieDao
import kotlinx.coroutines.flow.Flow

/**
 * Created by Iqbal Fauzi on 3/9/21 11:16 AM
 * iqbal.fauzi.if99@gmail.com
 */
class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getMovie(movieId: Int): Flow<MovieEntity> = movieDao.getMovie(movieId)

    suspend fun insertMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    suspend fun insertMovie(movie: MovieEntity) = movieDao.insertMovie(movie)

    fun updateMovie(movie: MovieEntity) = movieDao.updateMovie(movie)

}