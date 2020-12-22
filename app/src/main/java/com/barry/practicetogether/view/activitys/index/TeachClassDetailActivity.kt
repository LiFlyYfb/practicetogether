package com.barry.practicetogether.view.activitys.index

import JClickListener
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.content.Intent
import com.barry.practicetogether.MyApplication
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnModelActivity
import kotlinx.android.synthetic.main.activity_teach_class_detail.*
import kotlinx.android.synthetic.main.include_toolbar.*

class TeachClassDetailActivity : BaseUnModelActivity() {
    companion object {
        fun startTeachClassDetailActivity(context: Context) {
            context.startActivity(Intent(context, TeachClassDetailActivity::class.java))
        }
    }

    override fun getTitleText(): String {
        return "曲库详情"
    }

    override fun getLayout(): Int {
        return R.layout.activity_teach_class_detail
    }

    override fun initViews() {
        initToolbar(commToolBar)
        tvDetailClass.setOnClickListener(JClickListener {
            MyApplication.clearActivityTask()

            finish()
            NewTestActivity.startNewTestActivity(this)
        })
    }

    override fun initData() {
    }
}