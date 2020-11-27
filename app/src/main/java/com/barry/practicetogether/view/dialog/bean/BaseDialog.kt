package com.barry.practicetogether.view.dialog.bean

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.barry.practicetogether.R

abstract class BaseDialog(context: Context) : Dialog(context, R.style.TWDialog) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLaytout())
        initView()
        window?.setGravity(gravity())
        val lp: WindowManager.LayoutParams = window!!.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }

    abstract fun getLaytout(): Int

    abstract fun initView()

    open fun gravity(): Int {
        return Gravity.BOTTOM
    }

}