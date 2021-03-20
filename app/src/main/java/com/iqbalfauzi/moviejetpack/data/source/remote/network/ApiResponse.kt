package com.iqbalfauzi.moviejetpack.data.source.remote.network

/**
 * Created by Iqbal Fauzi on 3/8/21 2:00 PM
 * iqbal.fauzi.if99@gmail.com
 */
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}
