package com.example.trailers.ui.fragment.movie.adapter

import com.example.trailers.R
import com.example.trailers.data.model.movie.actors.Cast
import com.example.trailers.databinding.LayoutItemActorsBinding
import com.example.trailers.ui.base.adapter.BaseAdapter

class ActorsAdapter(data: List<Cast>) : BaseAdapter<LayoutItemActorsBinding, Cast>(data) {

    override val layoutId = R.layout.layout_item_actors

    private var onItemClickListener: ((Cast) -> Unit)? = null
    fun onItemClickListener(listener: (Cast) -> Unit) {
        onItemClickListener = listener
    }

    override fun bind(binding: LayoutItemActorsBinding, item1: Int, item: Cast) {
        binding.apply {
            actor = item
            actorsPoster.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }

        }
    }

}