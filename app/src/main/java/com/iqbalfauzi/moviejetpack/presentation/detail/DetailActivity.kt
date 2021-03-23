package com.iqbalfauzi.moviejetpack.presentation.detail

import android.os.Bundle
import android.transition.Explode
import android.view.Window
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.updateLayoutParams
import coil.load
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.ActivityDetailBinding
import com.iqbalfauzi.moviejetpack.domain.base.view.BaseActivity
import com.iqbalfauzi.moviejetpack.external.extensions.PlaceholderType
import com.iqbalfauzi.moviejetpack.external.extensions.loadImage
import com.iqbalfauzi.moviejetpack.external.extensions.makeStatusBarTransparent
import com.iqbalfauzi.moviejetpack.external.extensions.setDimensions
import kotlin.math.roundToInt

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>(
    DetailViewModel::class,
    ActivityDetailBinding::inflate
) {

    private val movieEntity: MovieEntity by lazy {
        return@lazy dataReceived?.getParcelable("DATA") ?: MovieEntity()
    }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupToolbar()
        setupInsets()
        with(binding) {
            val backDropUrl = "${BuildConfig.BASE_IMAGE_URL}${movieEntity.backdropPath}"
            val posterUrl = "${BuildConfig.BASE_IMAGE_URL}${movieEntity.posterPath}"

            ivBackdrop.loadImage(backDropUrl, PlaceholderType.LIGHT)
            ivPoster.loadImage(posterUrl)
            tvTitle.text = movieEntity.title
            tvDate.text = movieEntity.releaseDate
            tvOverview.text = movieEntity.overview
        }
    }

    private fun setupInsets() {
        makeStatusBarTransparent()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            insets.consumeSystemWindowInsets()
        }
    }

    private fun setupToolbar() {
        with(binding) {
            setSupportActionBar(toolbar)
            toolbar.title = " "
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
        super.onBackPressed()
    }

}