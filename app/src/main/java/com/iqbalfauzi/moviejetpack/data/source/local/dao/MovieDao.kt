package com.iqbalfauzi.moviejetpack.data.source.local.dao

import androidx.room.*
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Iqbal Fauzi on 3/9/21 9:45 AM
 * iqbal.fauzi.if99@gmail.com
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntity")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieEntity WHERE id=:movieId")
    fun getMovie(movieId: Int): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Update
    fun updateMovie(movie: MovieEntity)

}