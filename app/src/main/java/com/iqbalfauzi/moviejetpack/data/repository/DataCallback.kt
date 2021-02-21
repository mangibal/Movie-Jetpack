package com.iqbalfauzi.moviejetpack.data.repository

/**
 * Created by Iqbal Fauzi on 2/21/21 2:00 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface DataCallback<T> {
    fun onSuccess(data: T)
    fun onError(message: String)
    fun onException(message: String)
}