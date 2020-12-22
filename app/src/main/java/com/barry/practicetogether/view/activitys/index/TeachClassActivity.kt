package com.barry.practicetogether.view.activitys.index

import JClickListener
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnModelActivity
import kotlinx.android.synthetic.main.activity_teach_class.*
import kotlinx.android.synthetic.main.include_toolbar.*

class TeachClassActivity : BaseUnModelActivity() {
    companion object {
        fun startTeachClassActivity(context: Context) {
            context.startActivity(Intent(context, TeachClassActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_teach_class
    }

    override fun getTitleText(): String {
        return "教学曲库"
    }

    override fun initViews() {
        initToolbar(commToolBar)
        tvDetail.setOnClickListener(JClickListener {
            TeachClassDetailActivity.startTeachClassDetailActivity(this)
        })
    }

    override fun initData() {
    }
}