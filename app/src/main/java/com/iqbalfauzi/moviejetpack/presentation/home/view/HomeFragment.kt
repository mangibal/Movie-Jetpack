package com.iqbalfauzi.moviejetpack.presentation.home.view

import android.os.Bundle
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.FragmentHomeBinding
import com.iqbalfauzi.moviejetpack.domain.base.fragment.BaseFragment
import com.iqbalfauzi.moviejetpack.external.observe
import com.iqbalfauzi.moviejetpack.external.show
import com.iqbalfauzi.moviejetpack.external.toast
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.HomeViewModel
import timber.log.Timber


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class, FragmentHomeBinding::inflate) {

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupData()
    }

    private fun setupData() {
        with(viewModel) {
            getNowPlayingMovie()
            // get error message
            observe(errorMessage, ::onErrorMessageReceived)
            // loading state
            observe(onProgressNowPlaying, ::onNowPlayingLoading)
            // observe now playing movie data
            observe(nowPlayingMovies, ::onNowPlayingReceived)
        }
    }

    private fun onNowPlayingReceived(movies: List<MovieEntity>) {
        Timber.i(movies.toString())
    }

    private fun onNowPlayingLoading(isLoading: Boolean) {
        binding.pbNowPlaying.show(isLoading)
    }

    private fun onErrorMessageReceived(message: String) {
        requireActivity().toast(message)
    }

}