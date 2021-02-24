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

    private val _onProgressUpcoming = MutableLiveData<Boolean>()
    val onProgressUpcoming: LiveData<Boolean> = _onProgressUpcoming

    private val _onProgressOnTheAir = MutableLiveData<Boolean>()
    val onProgressOnTheAir: LiveData<Boolean> = _onProgressOnTheAir

    private val _onProgressPopular = MutableLiveData<Boolean>()
    val onProgressPopular: LiveData<Boolean> = _onProgressPopular

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
        _onProgressUpcoming.postValue(true)
        viewModelScope.launch {
            repository.getUpcomingMovie(page, object : DataCallback<List<MovieEntity>> {
                override fun onSuccess(data: List<MovieEntity>) {
                    _upcomingMovies.postValue(data)
                    _onProgressUpcoming.postValue(false)
                }

                override fun onError(message: String) {
                    _onProgressUpcoming.postValue(false)
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _onProgressUpcoming.postValue(false)
                    _errorMessage.postValue(message)
                }

            })
        }
    }

    fun getOnTheAirTv(page: Int = 1) {
        _onProgressOnTheAir.postValue(true)
        viewModelScope.launch {
            repository.getOnTheAirTv(page, object : DataCallback<List<TvShowEntity>> {
                override fun onSuccess(data: List<TvShowEntity>) {
                    _onTheAirTvList.postValue(data)
                    _onProgressOnTheAir.postValue(false)
                }

                override fun onError(message: String) {
                    _onProgressOnTheAir.postValue(false)
                    _errorMessage.postValue(message)
                }

                override fun onException(message: String) {
                    _onProgressOnTheAir.postValue(false)
                    _errorMessage.postValue(message)
                }

            })
        }
    }

    fun getPopularTvShow(page: Int = 1) {
        _onProgressPopular.postValue(true)
        viewModelScope.launch {
            repository.getPopularTvShow(page, object : DataCallback<List<TvShowEntity>> {
                override fun onSuccess(data: List<TvShowEntity>) {
                    _popularTvShow.postValue(data)
                    _onProgressPopular.postValue(false)
                }

                override fun onError(message: String) {
                    _errorMessage.postValue(message)
                    _onProgressPopular.postValue(false)
                }

                override fun onException(message: String) {
                    _errorMessage.postValue(message)
                    _onProgressPopular.postValue(false)
                }

            })
        }
    }

}