package com.iqbalfauzi.moviejetpack.data.model.movie

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Created by Iqbal Fauzi on 2/21/21 1:39 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class DateEntity(
    @Json(name = "maximum") val maximum: String,
    @Json(name = "minimum") val minimum: String
) : Parcelable