package com.zeus.app.view.weidget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.barry.practicetogether.R
import com.barry.practicetogether.utlis.rotation360
import com.barry.practicetogether.utlis.stop

class TimeView(context: Context,attrs: AttributeSet) :FrameLayout(context,attrs){
    init {
//        LayoutInflater.from(context).inflate(R.layout.view_time,this,true)
//        rotation360(timeIcon)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stop()
    }
}