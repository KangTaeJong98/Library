package com.taetae98.modules.library.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.taetae98.modules.library.base.BaseBottomSheetDialogFragment
import com.taetae98.modules.library.base.BaseFragment

abstract class BindingBottomSheetDialogFragment<VB: ViewDataBinding>(
    @LayoutRes
    private val layoutRes: Int
) : BaseBottomSheetDialogFragment() {
    private var _binding: VB? = null
    protected val binding: VB
        get() {
            return _binding!!
        }

    protected val behavior by lazy { BottomSheetBehavior.from(binding.root.parent as View) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        onCreateViewDataBinding()

        return binding.root
    }

    protected open fun onCreateViewDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}