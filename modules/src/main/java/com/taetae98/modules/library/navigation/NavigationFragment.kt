package com.taetae98.modules.library.navigation

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.taetae98.modules.library.binding.BindingFragment

abstract class NavigationFragment<VB: ViewDataBinding>(
    @LayoutRes
    layoutRes: Int
) : BindingFragment<VB>(layoutRes) {
    protected open fun navigateUp() {
        if (!findNavController().navigateUp()) {
            finish()
        }
    }

    protected open fun setResultValue(key: String, value: Any) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, value)
    }

    protected open fun<T: Any> getResultValue(key: String): T? {
        return findNavController().currentBackStackEntry?.savedStateHandle?.get<T>(key)
    }

    protected open fun<T: Any> getResultLiveData(key: String): MutableLiveData<T>? {
        return findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData(key)
    }
}