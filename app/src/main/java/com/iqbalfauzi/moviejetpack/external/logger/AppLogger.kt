package com.iqbalfauzi.moviejetpack.external.logger

import com.iqbalfauzi.moviejetpack.BuildConfig
import com.orhanobut.logger.Logger
import timber.log.Timber

/**
 * Created by Iqbal Fauzi on 2/22/21 9:12 AM
 * iqbal.fauzi.if99@gmail.com
 */
object AppLogger {

    fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    Logger.log(priority, tag, message, t)
                }
            })
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    fun debug(s: String, vararg objects: Any) {
        Timber.d(s, *objects)
    }

    fun debug(throwable: Throwable, s: String, vararg objects: Any) {
        Timber.d(throwable, s, *objects)
    }

    fun info(s: String, vararg objects: Any) {
        Timber.i(s, *objects)
    }

    fun info(throwable: Throwable, s: String, vararg objects: Any) {
        Timber.i(throwable, s, *objects)
    }

    fun warning(s: String, vararg objects: Any) {
        Timber.w(s, *objects)
    }

    fun warning(throwable: Throwable, s: String, vararg objects: Any) {
        Timber.w(throwable, s, *objects)
    }

    fun error(s: String, vararg objects: Any) {
        Timber.e(s, *objects)
    }

    fun error(throwable: Throwable, s: String, vararg objects: Any) {
        Timber.e(throwable, s, *objects)
    }

    fun verbose(s: String, vararg objects: Any) {
        Timber.v(s, *objects)
    }

    fun verbose(throwable: Throwable, s: String, vararg objects: Any) {
        Timber.v(throwable, s, *objects)
    }

}