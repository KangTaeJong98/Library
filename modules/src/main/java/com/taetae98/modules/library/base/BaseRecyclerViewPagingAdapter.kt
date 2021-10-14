package com.taetae98.modules.library.base

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kotlinx.coroutines.selects.whileSelect

abstract class BaseRecyclerViewPagingAdapter<T: Any>(diffCallback: DiffUtil.ItemCallback<T>) : PagingDataAdapter<T, BaseViewHolder<T>>(diffCallback) {
    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        getItem(position)?.let { item ->
            holder.onBindViewHolder(item)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        getItem(position)?.let { item ->
            holder.onBindViewHolder(item, payloads)
        }
    }
}