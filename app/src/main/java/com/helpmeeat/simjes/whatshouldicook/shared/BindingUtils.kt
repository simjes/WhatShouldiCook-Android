package com.helpmeeat.simjes.whatshouldicook.shared

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageBinding {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }
}