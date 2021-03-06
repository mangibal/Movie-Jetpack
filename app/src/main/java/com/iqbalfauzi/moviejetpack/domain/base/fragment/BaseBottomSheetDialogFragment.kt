package com.iqbalfauzi.moviejetpack.domain.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by Iqbal Fauzi on 20/02/2021
 * iqbal.fauzi.if99@gmail.com
 */
abstract class BaseBottomSheetDialogFragment<out VM : ViewModel, VB : ViewBinding>(
    kClass: KClass<VM>,
    private val viewBinder: (LayoutInflater) -> ViewBinding
) : BottomSheetDialogFragment() {

    @Suppress("UNCHECKED_CAST")
    protected val binding by lazy(LazyThreadSafetyMode.NONE) { viewBinder.invoke(layoutInflater) as VB }
    protected val viewModel: VM by viewModel(kClass)
    protected val sharedViewModel: VM by sharedViewModel(kClass)
    protected var dataReceived: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataReceived = arguments
        onInitUI(savedInstanceState)
    }

    abstract fun onInitUI(savedInstanceState: Bundle?)

}