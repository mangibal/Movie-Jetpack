package com.iqbalfauzi.moviejetpack.presentation.home.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.FragmentHomeBinding
import com.iqbalfauzi.moviejetpack.domain.base.fragment.BaseFragment
import com.iqbalfauzi.moviejetpack.external.extensions.observe
import com.iqbalfauzi.moviejetpack.external.extensions.show
import com.iqbalfauzi.moviejetpack.external.extensions.toast
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.NowPlayingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnMovieClickListener
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class,
    FragmentHomeBinding::inflate
), OnMovieClickListener {

    private val nowPlayingAdapter: NowPlayingAdapter by lazy {
        return@lazy NowPlayingAdapter(this)
    }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupData()
        setupBanner()
    }

    private fun setupBanner() {
        with(binding) {
            val snapHelper = PagerSnapHelper()
            rvNowPlaying.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = nowPlayingAdapter
                setHasFixedSize(true)
                snapHelper.attachToRecyclerView(this)
                rvIndicator.attachToRecyclerView(this)
            }
        }
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
        nowPlayingAdapter.setData(movies)
    }

    private fun onNowPlayingLoading(isLoading: Boolean) {
        binding.pbNowPlaying.show(isLoading)
    }

    private fun onErrorMessageReceived(message: String) {
        requireActivity().toast(message)
    }

    override fun onMovieClickListener(movie: MovieEntity) {

    }

}