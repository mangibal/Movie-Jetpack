package com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.ItemBannerBinding
import com.iqbalfauzi.moviejetpack.external.extensions.coil
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnMovieClickListener

/**
 * Created by Iqbal Fauzi on 2/22/21 9:36 AM
 * iqbal.fauzi.if99@gmail.com
 */
class NowPlayingAdapter(private val listener: OnMovieClickListener) :
    RecyclerView.Adapter<NowPlayingAdapter.NowPlayingHolder>() {

    private var list: List<MovieEntity> = emptyList()

    inner class NowPlayingHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieEntity) {
            with(binding) {
                val imageUrl = "${BuildConfig.BASE_IMAGE_URL}${item.posterPath}"
                ivBanner.coil(imageUrl)
                tvTitle.text = item.title
                root.setOnClickListener { listener.onMovieClickListener(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerBinding.inflate(inflater, parent, false)
        return NowPlayingHolder(binding)
    }

    override fun onBindViewHolder(holder: NowPlayingHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    fun setData(values: List<MovieEntity>) {
        list = values
        notifyDataSetChanged()
    }

}