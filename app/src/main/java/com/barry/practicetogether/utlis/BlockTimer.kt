package com.barry.practicetogether.utlis
import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.TextView
import com.barry.practicetogether.model.utils.loge

class BlockTimer(
    var textView: TextView,
    var endTime:Long,
     millisInFuture: Long,
    var onTimerFinishListener: TimerFinishListener
) : CountDownTimer(millisInFuture, 1000) {

    override fun onFinish() {
        onTimerFinishListener.onFinish()
    }

    @SuppressLint("SetTextI18n")
    override fun onTick(millisUntilFinished: Long) {
        loge("onTick")
        textView.text = offsetTime(System.currentTimeMillis(), endTime)
    }
}

interface TimerFinishListener{
    fun onFinish()
}
