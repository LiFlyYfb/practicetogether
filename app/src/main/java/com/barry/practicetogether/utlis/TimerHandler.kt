package com.zeus.app.utils

import android.os.Handler
import android.widget.TextView
import com.barry.practicetogether.utlis.offsetTime

class TimerHandler(var text: TextView,endTime:Long,var timeFinishListener: TimeFinishListener) : Handler() {

    fun start(){
        post(timeRunnable)
    }

    private var timeRunnable= object :Runnable{
        override fun run() {
            if (System.currentTimeMillis()>endTime){
                finish()
                timeFinishListener.onFinish()
                return
            }
            text.text = offsetTime(System.currentTimeMillis(),endTime)
            postDelayed(this,1000)
        }
    }

    fun finish(){
        removeCallbacks(timeRunnable)
    }
}

interface TimeFinishListener{
    fun onFinish()
}
