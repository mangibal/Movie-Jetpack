package com.iqbalfauzi.moviejetpack.domain.repository.usescase

import android.os.Parcelable
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by Iqbal Fauzi on 3/20/21 1:09 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Parcelize
data class MovieUiModel(
    var id: Int,
    var title: String,
    var date: String,
    var poster: String,
    var backdrop: String
) : Parcelable {
    constructor(movieEntity: MovieEntity) : this(
        id = movieEntity.id,
        title = movieEntity.title,
        date  =  movieEntity.releaseDate,
        poster = "${BuildConfig.BASE_IMAGE_URL}${movieEntity.posterPath}",
        backdrop = "${BuildConfig.BASE_IMAGE_URL}${movieEntity.backdropPath}"
    )
}
