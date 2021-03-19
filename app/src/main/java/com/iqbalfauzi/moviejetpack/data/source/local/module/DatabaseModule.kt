package com.iqbalfauzi.moviejetpack.data.source.local.module

import androidx.room.Room
import com.iqbalfauzi.moviejetpack.data.source.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 3/9/21 11:10 AM
 * iqbal.fauzi.if99@gmail.com
 */
val databaseModule = module {
    factory { get<AppDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "MovieJetpack.db"
        ).fallbackToDestructiveMigration().build()
    }
}