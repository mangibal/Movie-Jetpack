package com.iqbalfauzi.moviejetpack.data

import com.squareup.moshi.Json

/**
 * Created by Iqbal Fauzi on 2/21/21 1:35 PM
 * iqbal.fauzi.if99@gmail.com
 */
open class BaseResponse {
    @Json(name = "status_message") val statusMessage: String? = null
    @Json(name = "success") val success: Boolean? = null
    @Json(name = "status_code") val statusCode: Int? = null
}