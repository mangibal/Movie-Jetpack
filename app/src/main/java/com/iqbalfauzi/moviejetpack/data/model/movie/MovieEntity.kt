package com.iqbalfauzi.moviejetpack.data.model.movie

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity.Companion.TABLE_NAME
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

/**
 * Created by Iqbal Fauzi on 2/21/21 1:38 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = TABLE_NAME)
data class MovieEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = MOVIE_ID)
    @Json(name = "id") val id: Int,

    @ColumnInfo(name = ADULT)
    @Json(name = "adult") val adult: Boolean,

    @ColumnInfo(name = BACKDROP_PATH)
    @Json(name = "backdrop_path") val backdropPath: String,

    @ColumnInfo(name = GENRE_IDS)
    @Json(name = "genre_ids") val genreIds: List<Int>,

    @ColumnInfo(name = ORIGINAL_LANGUAGE)
    @Json(name = "original_language") val originalLanguage: String,

    @ColumnInfo(name = ORIGINAL_TITLE)
    @Json(name = "original_title") val originalTitle: String,

    @ColumnInfo(name = OVERVIEW)
    @Json(name = "overview") val overview: String,

    @ColumnInfo(name = POPULARITY)
    @Json(name = "popularity") val popularity: Double,

    @ColumnInfo(name = POSTER_PATH)
    @Json(name = "poster_path") val posterPath: String,

    @ColumnInfo(name = RELEASE_DATE)
    @Json(name = "release_date") val releaseDate: String,

    @ColumnInfo(name = TITLE)
    @Json(name = "title") val title: String,

    @ColumnInfo(name = VIDEO)
    @Json(name = "video") val video: Boolean,

    @ColumnInfo(name = VOTE_AVERAGE)
    @Json(name = "vote_average") val voteAverage: Double,

    @ColumnInfo(name = VOTE_COUNT)
    @Json(name = "vote_count") val voteCount: Int
) : Parcelable {
    companion object {
        const val TABLE_NAME = "movieEntity"
        const val MOVIE_ID = "id"
        const val ADULT = "adult"
        const val BACKDROP_PATH = "backdropPath"
        const val GENRE_IDS = "genreIds"
        const val ORIGINAL_LANGUAGE = "originalLanguage"
        const val ORIGINAL_TITLE = "originalTitle"
        const val OVERVIEW = "overview"
        const val POPULARITY = "popularity"
        const val POSTER_PATH = "posterPath"
        const val RELEASE_DATE = "releaseDate"
        const val TITLE = "title"
        const val VIDEO = "video"
        const val VOTE_AVERAGE = "voteAverage"
        const val VOTE_COUNT = "voteCount"
    }
}