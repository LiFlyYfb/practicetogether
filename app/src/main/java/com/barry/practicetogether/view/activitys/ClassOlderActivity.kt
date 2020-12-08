package com.barry.practicetogether.view.activitys

import android.content.Context
import android.content.Intent
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnModelActivity

class ClassOlderActivity : BaseUnModelActivity() {
    companion object {
        fun startClassOlderActivity(context: Context) {
            context.startActivity(Intent(context, ClassOlderActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_class_older
    }

    override fun initViews() {
    }

    override fun initData() {
    }
}