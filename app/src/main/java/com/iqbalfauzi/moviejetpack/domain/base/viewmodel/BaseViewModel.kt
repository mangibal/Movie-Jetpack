package com.iqbalfauzi.moviejetpack.domain.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbalfauzi.moviejetpack.data.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Iqbal Fauzi on 2/21/21 2:07 PM
 * iqbal.fauzi.if99@gmail.com
 */
open class BaseViewModel: ViewModel(), KoinComponent {

    protected val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    val repository: Repository by inject()

}