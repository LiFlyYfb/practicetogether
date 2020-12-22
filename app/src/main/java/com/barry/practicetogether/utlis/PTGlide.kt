package com.barry.practicetogether.utlis

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class PTGlide : AppGlideModule() {
    companion object {
        fun load(context: Context, imageView: ImageView, url: String) {
            Glide.with(context)
                .load(url)
                .dontAnimate()
                .into(imageView)
        }


        fun loadCenterCrop(context: Context, imageView: ImageView, url: String) {
            Glide.with(context)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }
}
