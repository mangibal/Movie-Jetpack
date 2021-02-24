package com.iqbalfauzi.moviejetpack.domain.base.holder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Iqbal Fauzi on 2/23/21 12:45 PM
 * iqbal.fauzi.if99@gmail.com
 */
abstract class BaseHolder<M>(binder: ViewBinding) :
    RecyclerView.ViewHolder(binder.root) {

    var model: M? = null
        set(model) {
            field = model
            model?.let {
                setContent(model)
            }
        }

    abstract fun setContent(data: M)

}