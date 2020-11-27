package com.barry.practicetogether.utlis
import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.TextView

class CountTimer(
    var textView: TextView,
    var endStr: String,
    millisInFuture: Long = 60000,
    countDownInterval: Long = 1000
) : CountDownTimer(millisInFuture, countDownInterval) {

    override fun onFinish() {
        textView.isClickable = true
        textView.text = endStr
    }

    @SuppressLint("SetTextI18n")
    override fun onTick(millisUntilFinished: Long) {
        textView.isClickable = false
        textView.text = "${millisUntilFinished / 1000} 秒"
    }

}