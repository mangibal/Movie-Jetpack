package com.iqbalfauzi.moviejetpack.presentation.home.adapter.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.tv.TvShowEntity
import com.iqbalfauzi.moviejetpack.databinding.ItemMovieBinding
import com.iqbalfauzi.moviejetpack.domain.base.holder.BaseHolder
import com.iqbalfauzi.moviejetpack.external.extensions.coil
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnTvClickListener

/**
 * Created by Iqbal Fauzi on 2/23/21 11:43 AM
 * iqbal.fauzi.if99@gmail.com
 */
class OnTheAirTvAdapter(private val listener: OnTvClickListener) :
    RecyclerView.Adapter<OnTheAirTvAdapter.ViewHolder>() {

    private var list: List<TvShowEntity> = emptyList()

    inner class ViewHolder(private val binding: ItemMovieBinding) : BaseHolder<TvShowEntity>(binding) {
        override fun setContent(data: TvShowEntity) {
            with(binding) {
                val imageUrl = "${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"
                ivPoster.coil(imageUrl)
                tvItemTitle.text = data.name
                tvItemDate.text = data.firstAirDate
                root.setOnClickListener { listener.onTvClickListener(data) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.setContent(list[position])

    override fun getItemCount(): Int = list.size

    fun setData(values: List<TvShowEntity>) {
        list = values
        notifyDataSetChanged()
    }
}
