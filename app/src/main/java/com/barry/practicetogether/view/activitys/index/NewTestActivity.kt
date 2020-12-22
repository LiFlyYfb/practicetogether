package com.barry.practicetogether.view.activitys.index

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnModelActivity
import kotlinx.android.synthetic.main.include_toolbar.*

class NewTestActivity : BaseUnModelActivity() {

    companion object {
        fun startNewTestActivity(context: Context) {
            context.startActivity(Intent(context, NewTestActivity::class.java))
        }
    }

    override fun getTitleText(): String {
        return "完成详情页面"
    }

    override fun getLayout(): Int {
        return R.layout.activity_new_test
    }

    override fun initViews() {
        initToolbar(commToolBar)
    }

    override fun initData() {
    }
}