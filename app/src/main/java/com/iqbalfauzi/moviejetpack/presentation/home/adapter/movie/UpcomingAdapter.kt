package com.iqbalfauzi.moviejetpack.presentation.home.adapter.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalfauzi.moviejetpack.BuildConfig
import com.iqbalfauzi.moviejetpack.data.model.movie.MovieEntity
import com.iqbalfauzi.moviejetpack.databinding.ItemMovieBinding
import com.iqbalfauzi.moviejetpack.domain.base.holder.BaseHolder
import com.iqbalfauzi.moviejetpack.external.extensions.coil
import com.iqbalfauzi.moviejetpack.presentation.home.listener.OnMovieClickListener

/**
 * Created by Iqbal Fauzi on 2/22/21 9:36 AM
 * iqbal.fauzi.if99@gmail.com
 */
class UpcomingAdapter(private val listener: OnMovieClickListener) :
    RecyclerView.Adapter<UpcomingAdapter.UpcomingHolder>() {

    private var list: List<MovieEntity> = emptyList()

    inner class UpcomingHolder(private val binding: ItemMovieBinding) :
        BaseHolder<MovieEntity>(binding) {
        override fun setContent(data: MovieEntity) {
            with(binding) {
                val imageUrl = "${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"
                ivPoster.coil(imageUrl)
                tvItemTitle.text = data.title
                tvItemDate.text = data.releaseDate
                root.setOnClickListener { listener.onMovieClickListener(data) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return UpcomingHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingHolder, position: Int) =
        holder.setContent(list[position])

    override fun getItemCount(): Int = list.size

    fun setData(values: List<MovieEntity>) {
        list = values
        notifyDataSetChanged()
    }

}