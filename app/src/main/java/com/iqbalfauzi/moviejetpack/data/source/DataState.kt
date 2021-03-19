package com.iqbalfauzi.moviejetpack.data.source

/**
 * Created by Iqbal Fauzi on 3/8/21 1:45 PM
 * iqbal.fauzi.if99@gmail.com
 */
sealed class DataState<out T>(val data: T? = null, val throwable: Throwable? = null) {
    class Success<out T>(data: T?): DataState<T>(data)
    class Error<out T>(throwable: Throwable, data: T? = null) : DataState<T>(data, throwable)
}

