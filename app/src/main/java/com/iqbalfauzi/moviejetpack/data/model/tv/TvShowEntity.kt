package com.iqbalfauzi.moviejetpack.data.model.tv


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Created by Iqbal Fauzi on 2/23/21 10:38 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class TvShowEntity(
    @Json(name = "backdrop_path") val backdropPath: String = "",
    @Json(name = "first_air_date") val firstAirDate: String = "",
    @Json(name = "genre_ids") val genreIds: List<Int> = emptyList(),
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String = "",
    @Json(name = "origin_country") val originCountry: List<String> = emptyList(),
    @Json(name = "original_language") val originalLanguage: String = "",
    @Json(name = "original_name") val originalName: String = "",
    @Json(name = "overview") val overview: String = "",
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "vote_average") val voteAverage: Double = 0.0,
    @Json(name = "vote_count") val voteCount: Int = 0
) : Parcelable