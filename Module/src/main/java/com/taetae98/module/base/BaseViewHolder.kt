package com.taetae98.module.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBindViewHolder(item: T)
}