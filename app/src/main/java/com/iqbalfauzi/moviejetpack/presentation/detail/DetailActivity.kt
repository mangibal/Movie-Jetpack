package com.iqbalfauzi.moviejetpack.presentation.detail

import android.os.Bundle
import coil.load
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.ActivityDetailBinding
import com.iqbalfauzi.moviejetpack.domain.base.view.BaseActivity

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>(
    DetailViewModel::class,
    ActivityDetailBinding::inflate
) {

    private val movieEntity: MovieEntity by lazy {
        return@lazy dataReceived?.getParcelable("DATA") ?: MovieEntity()
    }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupToolbar()
        with(binding) {
            val imageUrl = "${BuildConfig.BASE_IMAGE_URL}${movieEntity.backdropPath}"
            ivBanner.load(imageUrl)
        }
    }

    private fun setupToolbar() {
        with(binding) {
            setSupportActionBar(toolbar)
            toolbar.title = movieEntity.title
            ctlDetail.title = " "
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}