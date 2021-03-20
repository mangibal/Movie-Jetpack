package com.iqbalfauzi.moviejetpack.external.logger

/**
 * Created by Iqbal Fauzi on 2/22/21 9:13 AM
 * iqbal.fauzi.if99@gmail.com
 */
object FakeCrashLibrary {

    fun log(priority: Int, tag: String?, message: String?) {
        // TODO add log entry to circular buffer.
    }

    fun logWarning(t: Throwable?) {
        // TODO report non-fatal warning.
    }

    fun logError(t: Throwable?) {
        // TODO report non-fatal error.
    }

    private fun fakeCrashLibrary() {
        throw AssertionError("No instances.")
    }

}