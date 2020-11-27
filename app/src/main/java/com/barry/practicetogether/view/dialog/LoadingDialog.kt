package com.barry.practicetogether.view.dialog

import android.content.Context
import android.os.Handler
import android.os.Message
import android.view.Gravity
import com.barry.practicetogether.R
import com.barry.practicetogether.utlis.rotation360
import com.barry.practicetogether.view.dialog.bean.BaseDialog
import kotlinx.android.synthetic.main.dialog_loading.*

class LoadingDialog(context: Context, var desc: String = "加载中...") : BaseDialog(context) {
    override fun getLaytout(): Int {
        return R.layout.dialog_loading
    }

    var showTime = 0L
    override fun initView() {
        rotation360(loadingIcon, 500)
        loadingDesc.text = desc
        showTime = System.currentTimeMillis()
    }

    override fun gravity(): Int {
        return Gravity.CENTER
    }

    fun delayeDismiss() {
        val endTime = System.currentTimeMillis()
        val d = endTime - showTime
        if (d > 800) {
            dismiss()
        } else {
            handler.sendEmptyMessageDelayed(0, 800 - d)
        }
    }

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            dismiss()
        }
    }

}