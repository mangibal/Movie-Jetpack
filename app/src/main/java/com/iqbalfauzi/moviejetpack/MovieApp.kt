package com.iqbalfauzi.moviejetpack

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.iqbalfauzi.moviejetpack.koin.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
class MovieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Disable Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // Initialize Koin Dependency Injection
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MovieApp)
            modules(appComponent)
        }
    }

}