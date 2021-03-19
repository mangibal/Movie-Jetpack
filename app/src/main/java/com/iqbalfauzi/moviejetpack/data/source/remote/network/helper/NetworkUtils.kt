package com.iqbalfauzi.moviejetpack.data.source.remote.network.helper

/**
 * Created by Iqbal Fauzi on 3/9/21 2:18 PM
 * iqbal.fauzi.if99@gmail.com
 */
suspend inline fun <T> callApi(crossinline apiCall: suspend () -> T): DataResult<T> {
    return try {
        DataResult.Success(apiCall())
    } catch (ex: Exception) {
        DataResult.Failure(ex)
    }
}