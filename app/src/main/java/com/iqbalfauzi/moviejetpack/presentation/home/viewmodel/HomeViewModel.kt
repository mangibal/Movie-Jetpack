package com.iqbalfauzi.moviejetpack.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
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

    fun getNowPlayingMovie(page: Int = 1) {
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

}