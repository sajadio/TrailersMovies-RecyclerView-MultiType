package com.example.trailers.ui.fragment.common.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trailers.data.model.movie.common.CommonResult
import com.example.trailers.databinding.LayoutItemCardCommonPagingBinding
import com.example.trailers.ui.fragment.home.adapter.OnClickListener

class CommonPagingAdapter : PagingDataAdapter<CommonResult, CommonPagingAdapter.CommonHolder>(CharacterComparator) {

    private var onItemClickListener: ((Int?) -> Unit)? = null
    fun onItemClickListener(listener: (Int?) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommonHolder(
            LayoutItemCardCommonPagingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CommonHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    inner class CommonHolder(private val binding: LayoutItemCardCommonPagingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: CommonResult) = apply {
            binding.apply {
                common = item
                root.setOnClickListener {
                    onItemClickListener?.let { it(item.id) }
                }
            }
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CommonResult>() {
        override fun areItemsTheSame(oldItem: CommonResult, newItem: CommonResult) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: CommonResult, newItem: CommonResult) =
            oldItem == newItem
    }
}