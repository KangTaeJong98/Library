package com.taetae98.modules.library.base

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.annotation.AnimRes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {
    protected open fun setLayout(width: Int, height: Int) {
        dialog?.window?.setLayout(width, height)
    }

    protected open fun setDrawable(drawable: Drawable?) {
        dialog?.window?.setBackgroundDrawable(drawable)
    }

    protected open fun setAnimation(@AnimRes animRes: Int) {
        dialog?.window?.attributes?.windowAnimations = animRes
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