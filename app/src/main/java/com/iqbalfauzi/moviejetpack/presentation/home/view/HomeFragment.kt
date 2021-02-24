package com.iqbalfauzi.moviejetpack.presentation.home.view

import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.databinding.FragmentHomeBinding
import com.iqbalfauzi.moviejetpack.domain.base.fragment.BaseFragment
import com.iqbalfauzi.moviejetpack.external.extensions.initRecyclerViewList
import com.iqbalfauzi.moviejetpack.external.extensions.observe
import com.iqbalfauzi.moviejetpack.external.extensions.show
import com.iqbalfauzi.moviejetpack.external.extensions.toast
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie.NowPlayingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie.UpcomingAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.tv.OnTheAirTvAdapter
import com.iqbalfauzi.moviejetpack.presentation.home.adapter.tv.PopularTvAdapter
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
        setupItemList()
    }

    private fun setupItemList() {
        with(binding) {
            with(requireActivity()) {
                initRecyclerViewList(rvUpcoming, false)
                initRecyclerViewList(rvOnTheAir, false)
                initRecyclerViewList(rvPopular, false)
            }
            rvUpcoming.adapter = upcomingAdapter
            rvOnTheAir.adapter = onTheAirTvAdapter
            rvPopular.adapter = popularTvAdapter
        }
    }

    private fun setupBanner() {
        with(binding) {
            val snapHelper = PagerSnapHelper()
            rvNowPlaying.apply {
                requireActivity().initRecyclerViewList(this, false)
                adapter = nowPlayingAdapter
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
            observe(onProgressUpcoming, ::onUpcomingLoading)
            observe(onProgressOnTheAir, ::onOnTheAirLoading)
            observe(onProgressPopular, ::onPopularLoading)

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

    private fun onUpcomingLoading(isLoading: Boolean) {
        with(binding) {
            shimmerUpcoming.shimmerHome.apply {
                show(isLoading)
                if (isLoading) {
                    startShimmer()
                } else {
                    stopShimmer()
                }
            }
            tvUpcomingTitle.show(!isLoading)
            rvUpcoming.show(!isLoading)
        }
    }

    private fun onOnTheAirLoading(isLoading: Boolean) {
        with(binding) {
            shimmerOnTheAir.shimmerHome.apply {
                show(isLoading)
                if (isLoading) {
                    startShimmer()
                } else {
                    stopShimmer()
                }
            }
            tvOnTheAir.show(!isLoading)
            rvOnTheAir.show(!isLoading)
        }
    }

    private fun onPopularLoading(isLoading: Boolean) {
        with(binding) {
            shimmerPopular.shimmerHome.apply {
                show(isLoading)
                if (isLoading) {
                    startShimmer()
                } else {
                    stopShimmer()
                }
            }
            tvPopular.show(!isLoading)
            rvPopular.show(!isLoading)
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