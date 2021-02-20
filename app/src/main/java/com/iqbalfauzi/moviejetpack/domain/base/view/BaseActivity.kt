package com.iqbalfauzi.moviejetpack.domain.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
abstract class BaseActivity<out VM: ViewModel, VB: ViewBinding>(
    kClass: KClass<VM>,
    private val viewBinder: (LayoutInflater) -> ViewBinding
): AppCompatActivity() {

    @Suppress("UNCHECKED_CAST")
    protected val binding by lazy(LazyThreadSafetyMode.NONE) { viewBinder.invoke(layoutInflater) as VB}
    protected val viewModel: VM by viewModel(kClass)
    protected var dataReceived: Bundle? = null
    protected var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dataReceived = intent.extras
        rootView = binding.root
        onInitUI(savedInstanceState)
    }

    abstract fun onInitUI(savedInstanceState: Bundle?)

}