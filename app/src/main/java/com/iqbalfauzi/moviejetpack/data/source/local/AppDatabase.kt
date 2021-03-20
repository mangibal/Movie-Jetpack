package com.iqbalfauzi.moviejetpack.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.source.local.converter.MovieGenreConverter
import com.iqbalfauzi.moviejetpack.data.source.local.dao.MovieDao

/**
 * Created by Iqbal Fauzi on 3/9/21 9:43 AM
 * iqbal.fauzi.if99@gmail.com
 */
@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
@TypeConverters(MovieGenreConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

}