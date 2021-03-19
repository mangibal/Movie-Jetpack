package com.iqbalfauzi.moviejetpack.data.source.remote.network.helper

/**
 * Created by Iqbal Fauzi on 3/9/21 2:20 PM
 * iqbal.fauzi.if99@gmail.com
 */
sealed class DataResult<out T> {

    /** Denotes that we successfully found / retrieved some data **/
    data class Success<T>(val data: T) : DataResult<T>()

    /** Denotes that we could not find some data. Throwable in ex **/
    data class Failure<T>(val ex: Throwable) : DataResult<T>()

}