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
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.UpcomingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnNowPlayingClickListener
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnUpcomingClickListener
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class,
    FragmentHomeBinding::inflate
), OnNowPlayingClickListener, OnUpcomingClickListener {

    private val nowPlayingAdapter: NowPlayingAdapter by lazy {
        return@lazy NowPlayingAdapter(this)
    }

    private val upcomingAdapter: UpcomingAdapter by lazy {
        return@lazy UpcomingAdapter(this)
    }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupData()
        setupBanner()
        setupUpcomingMovies()
    }

    private fun setupUpcomingMovies() {
        with(binding) {
            rvUpcoming.adapter = upcomingAdapter
        }
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
            getNowPlayingMovies()
            getUpcomingMovies()
            // get error message
            observe(errorMessage, ::onErrorMessageReceived)
            // loading state
            observe(onProgressNowPlaying, ::onNowPlayingLoading)
            // observe now playing movie data
            observe(nowPlayingMovies, ::onNowPlayingReceived)
            // obser upcoming movies data
            observe(upcomingMovies, ::onUpcomingReceived)
        }
    }

    private fun onUpcomingReceived(movies: List<MovieEntity>) {
        upcomingAdapter.setData(movies)
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

    override fun onNowPlayingClickListener(movie: MovieEntity) {

    }

    override fun onUpcomingClickListener(movie: MovieEntity) {

    }

}