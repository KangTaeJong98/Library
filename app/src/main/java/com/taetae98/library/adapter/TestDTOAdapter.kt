package com.taetae98.library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.taetae98.library.databinding.HolderDtoBinding
import com.taetae98.library.dto.TestDTO
import com.taetae98.modules.library.base.BaseViewHolder
import com.taetae98.modules.library.binding.BindingRecyclerViewAdapter
import com.taetae98.modules.library.binding.BindingViewHolder

class TestDTOAdapter(viewLifecycleOwner: LifecycleOwner? = null) : BindingRecyclerViewAdapter<TestDTO>(diffCallback, viewLifecycleOwner) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<TestDTO>() {
            override fun areItemsTheSame(oldItem: TestDTO, newItem: TestDTO): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: TestDTO, newItem: TestDTO): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TestDTO> {
        return TestTDOHolder(
            HolderDtoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), viewLifecycleOwner
        )
    }

    inner class TestTDOHolder(binding: HolderDtoBinding, viewLifecycleOwner: LifecycleOwner?) : BindingViewHolder<TestDTO, HolderDtoBinding>(binding, viewLifecycleOwner)
}