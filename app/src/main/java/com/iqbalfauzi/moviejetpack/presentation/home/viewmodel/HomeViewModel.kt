package com.iqbalfauzi.moviejetpack.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.data.repository.DataCallback
import com.iqbalfauzi.moviejetpack.domain.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Iqbal Fauzi on 2/21/21 2:06 PM
 * iqbal.fauzi.if99@gmail.com
 */
class HomeViewModel : BaseViewModel() {

    private val _onProgressNowPlaying: MutableLiveData<Boolean> = MutableLiveData()
    val onProgressNowPlaying: LiveData<Boolean> = _onProgressNowPlaying

    private val _nowPlayingMovies: MutableLiveData<List<MovieEntity>> = MutableLiveData()
    val nowPlayingMovies: LiveData<List<MovieEntity>> = _nowPlayingMovies

    private val _upcomingMovies: MutableLiveData<List<MovieEntity>> = MutableLiveData()
    val upcomingMovies: LiveData<List<MovieEntity>> = _upcomingMovies

    private val _onTheAirTvList: MutableLiveData<List<TvShowEntity>> = MutableLiveData()
    val onTheAirTvList: LiveData<List<TvShowEntity>> = _onTheAirTvList

    private val _popularTvShow: MutableLiveData<List<TvShowEntity>> = MutableLiveData()
    val popularTvShow: LiveData<List<TvShowEntity>> = _popularTvShow

    fun getNowPlayingMovies(page: Int = 1) {
        _onProgressNowPlaying.postValue(true)
        viewModelScope.launch {
            repository.getNowPlayingMovie(page, object : DataCallback<List<MovieEntity>> {
                override fun onSuccess(data: List<MovieEntity>) {
                    _nowPlayingMovies.postValue(data)
                    _onProgressNowPlaying.postValue(false)
                }

                override fun onError(message: String) {
                    _onProgressNowPlaying.postValue(false)
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _onProgressNowPlaying.postValue(false)
                    _errorMessage.postValue(message)
                }

            })
        }
    }

    fun getUpcomingMovies(page: Int = 1) {
        viewModelScope.launch {
            repository.getUpcomingMovie(page, object : DataCallback<List<MovieEntity>> {
                override fun onSuccess(data: List<MovieEntity>) {
                    _upcomingMovies.postValue(data)
                }

                override fun onError(message: String) {
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _errorMessage.postValue(message)
                }

            })
        }
    }

    fun getOnTheAirTv(page: Int = 1) {
        viewModelScope.launch {
            repository.getOnTheAirTv(page, object : DataCallback<List<TvShowEntity>> {
                override fun onSuccess(data: List<TvShowEntity>) {
                    _onTheAirTvList.postValue(data)
                }

                override fun onError(message: String) {
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _errorMessage.postValue(message)
                }

            })
        }
    }

    fun getPopularTvShow(page: Int = 1) {
        viewModelScope.launch {
            repository.getPopularTvShow(page, object : DataCallback<List<TvShowEntity>> {
                override fun onSuccess(data: List<TvShowEntity>) {
                    _popularTvShow.postValue(data)
                }

                override fun onError(message: String) {
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _errorMessage.postValue(message)
                }

            })
        }
    }

}