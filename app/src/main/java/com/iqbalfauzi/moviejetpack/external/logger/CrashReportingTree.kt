package com.iqbalfauzi.moviejetpack.external.logger

import android.util.Log
import com.iqbalfauzi.moviejetpack.external.logger.FakeCrashLibrary.logError
import com.iqbalfauzi.moviejetpack.external.logger.FakeCrashLibrary.logWarning
import timber.log.Timber

/**
 * Created by Iqbal Fauzi on 2/22/21 9:12 AM
 * iqbal.fauzi.if99@gmail.com
 */
class CrashReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
        FakeCrashLibrary.log(priority, tag, message)
        if (t != null) {
            if (priority == Log.ERROR) {
                logError(t)
            } else if (priority == Log.WARN) {
                logWarning(t)
            }
        }
    }
}