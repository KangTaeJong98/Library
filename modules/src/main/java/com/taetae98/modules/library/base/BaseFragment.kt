package com.taetae98.modules.library.base

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected fun setSupportActionBar(toolbar: Toolbar) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
    }

    protected open fun setResult(resultCode: Int = Activity.RESULT_CANCELED, data: Intent? = null) {
        requireActivity().setResult(resultCode, data)
    }

    protected open fun <T> getSystemService(serviceClass: Class<T>): T {
        return requireContext().getSystemService(serviceClass)
    }

    protected open fun finish() {
        requireActivity().finish()
    }
}