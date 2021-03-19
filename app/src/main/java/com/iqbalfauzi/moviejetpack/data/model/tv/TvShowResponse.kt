package com.iqbalfauzi.moviejetpack.data.model.tv


import android.os.Parcelable
import com.iqbalfauzi.moviejetpack.data.model.BaseResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Created by Iqbal Fauzi on 2/23/21 10:38 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class TvShowResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val result: List<TvShowEntity>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
) : BaseResponse(), Parcelable