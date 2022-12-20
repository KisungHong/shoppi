package com.shoppi.app.ui.common

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun updateVisibility(view: View, inVisible : Boolean) {
    view.visibility = if (inVisible) View.VISIBLE else View.GONE
}