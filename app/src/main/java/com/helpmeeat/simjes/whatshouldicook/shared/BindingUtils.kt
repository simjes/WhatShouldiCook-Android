package com.helpmeeat.simjes.whatshouldicook.shared

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageBinding {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String = "http://www.h1z1config.com/wp-content/uploads/2016/12/maxresdefault-2-e1481655934837-300x252.jpg") {
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }
}