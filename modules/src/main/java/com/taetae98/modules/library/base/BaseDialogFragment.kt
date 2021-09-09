package com.taetae98.modules.library.base

import android.graphics.drawable.Drawable
import androidx.annotation.AnimRes
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {
    protected fun setLayout(width: Int, height: Int) {
        dialog?.window?.setLayout(width, height)
    }

    protected fun setDrawable(drawable: Drawable?) {
        dialog?.window?.setBackgroundDrawable(drawable)
    }

    protected fun setAnimation(@AnimRes animRes: Int) {
        dialog?.window?.attributes?.windowAnimations = animRes
    }

    protected fun finish() {
        requireActivity().finish()
    }
}