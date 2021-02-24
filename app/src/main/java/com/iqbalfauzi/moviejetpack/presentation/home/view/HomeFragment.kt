package com.iqbalfauzi.moviejetpack.presentation.home.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.databinding.FragmentHomeBinding
import com.iqbalfauzi.moviejetpack.domain.base.fragment.BaseFragment
import com.iqbalfauzi.moviejetpack.external.extensions.observe
import com.iqbalfauzi.moviejetpack.external.extensions.show
import com.iqbalfauzi.moviejetpack.external.extensions.toast
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie.NowPlayingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.tv.OnTheAirTvAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.tv.PopularTvAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie.UpcomingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnMovieClickListener
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnTvClickListener
import com.iqbalfauzi.moviejetpack.presentation.home.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class,
    FragmentHomeBinding::inflate
), OnMovieClickListener, OnTvClickListener {

    private val nowPlayingAdapter: NowPlayingAdapter by lazy {
        return@lazy NowPlayingAdapter(this)
    }

    private val upcomingAdapter: UpcomingAdapter by lazy {
        return@lazy UpcomingAdapter(this)
    }

    private val popularTvAdapter: PopularTvAdapter by lazy {
        return@lazy PopularTvAdapter(this)
    }

    private val onTheAirTvAdapter: OnTheAirTvAdapter by lazy {
        return@lazy OnTheAirTvAdapter(this)
    }

    override fun onInitUI(savedInstanceState: Bundle?) {
        setupData()
        setupBanner()
        setupUpcomingMovies()
        setupPopularTvShow()
        setupOnTheAirTvShow()
    }

    private fun setupOnTheAirTvShow() {
        binding.rvOnTheAir.adapter = onTheAirTvAdapter
    }

    private fun setupPopularTvShow() {
        binding.rvPopular.adapter = popularTvAdapter
    }

    private fun setupUpcomingMovies() {
        binding.rvUpcoming.adapter = upcomingAdapter
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
            getOnTheAirTv()
            getPopularTvShow()
            // get error message
            observe(errorMessage, ::onErrorMessageReceived)
            // loading state
            observe(onProgressNowPlaying, ::onNowPlayingLoading)
            // observe now playing movie data
            observe(nowPlayingMovies, ::onNowPlayingReceived)
            // observe upcoming movies data
            observe(upcomingMovies, ::onUpcomingReceived)
            // observe on the air tv show data
            observe(onTheAirTvList, ::onOnTheAirTvReceived)
            // observe popular tv show data
            observe(popularTvShow, ::onPopularTvShowReceived)
        }
    }

    private fun onOnTheAirTvReceived(values: List<TvShowEntity>) {
        onTheAirTvAdapter.setData(values)
    }

    private fun onPopularTvShowReceived(values: List<TvShowEntity>) {
        popularTvAdapter.setData(values)
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

    override fun onMovieClickListener(movie: MovieEntity) {
        requireActivity().toast(movie.toString())
    }

    override fun onTvClickListener(tvEntity: TvShowEntity) {
        requireActivity().toast(tvEntity.toString())
    }


}