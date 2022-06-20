package com.example.hilt_mvi.util

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageUrl")
fun loadImage(imageView: ImageView, url: String?) {

    if (!url.isNullOrBlank()) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    }
}

@BindingAdapter("setQuantity")
fun setQuantity(textView: AppCompatTextView, quantity: String?) {
    val text = StringBuilder().append("Quantity:").append(quantity).toString()
    textView.text = text
}

