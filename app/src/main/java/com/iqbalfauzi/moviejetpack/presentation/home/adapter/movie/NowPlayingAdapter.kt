package com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.ItemBannerBinding
import com.iqbalfauzi.moviejetpack.domain.base.holder.BaseHolder
import com.iqbalfauzi.moviejetpack.external.extensions.PlaceholderType
import com.iqbalfauzi.moviejetpack.external.extensions.loadImage
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnMovieClickListener

/**
 * Created by Iqbal Fauzi on 2/22/21 9:36 AM
 * iqbal.fauzi.if99@gmail.com
 */
class NowPlayingAdapter(private val listener: OnMovieClickListener) :
    RecyclerView.Adapter<NowPlayingAdapter.NowPlayingHolder>() {

    private var list: List<MovieEntity> = emptyList()

    inner class NowPlayingHolder(private val binding: ItemBannerBinding) :
        BaseHolder<MovieEntity>(binding) {
        override fun setContent(data: MovieEntity) {
            with(binding) {
                val imageUrl = "${BuildConfig.BASE_IMAGE_URL}${data.backdropPath}"
                ivBanner.loadImage(imageUrl, PlaceholderType.LIGHT)
                tvTitle.text = data.title
                root.setOnClickListener { listener.onMovieClickListener(data) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerBinding.inflate(inflater, parent, false)
        return NowPlayingHolder(binding)
    }

    override fun onBindViewHolder(holder: NowPlayingHolder, position: Int) =
        holder.setContent(list[position])

    override fun getItemCount(): Int = list.size

    fun setData(values: List<MovieEntity>) {
        list = values
        notifyDataSetChanged()
    }

}