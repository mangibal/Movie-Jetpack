package com.iqbalfauzi.moviejetpack.data.model.movie

import android.os.Parcelable
import com.iqbalfauzi.moviejetpack.data.BaseResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Created by Iqbal Fauzi on 2/21/21 1:38 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name = "dates") val dates: DateEntity,
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<MovieEntity>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
) : BaseResponse(), Parcelable