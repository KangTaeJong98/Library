package com.taetae98.library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.taetae98.library.BR
import com.taetae98.library.databinding.HolderDtoBinding
import com.taetae98.library.dto.TestDTO
import com.taetae98.modules.library.base.BaseRecyclerViewAdapter
import com.taetae98.modules.library.base.BaseViewHolder
import com.taetae98.modules.library.util.SimpleSelectionTracker

class TestDTOAdapter : BaseRecyclerViewAdapter<TestDTO>(diffCallback) {
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

    var selectionTracker: SimpleSelectionTracker? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TestDTO> {
        return TestTDOHolder(
            HolderDtoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class TestTDOHolder(private val binding: HolderDtoBinding) : BaseViewHolder<TestDTO>(binding.root) {
        private var dto: TestDTO? = null
            set(value) {
                field = value
                binding.setVariable(BR.testDto, value)
            }

        override fun onBindViewHolder(item: TestDTO) {
            super.onBindViewHolder(item)
            dto = item
        }
    }
}