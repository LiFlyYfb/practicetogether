package com.barry.practicetogether.view.activitys.index

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.Spanned
import android.text.StaticLayout
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.MyTask
import com.barry.practicetogether.presenter.index.MyTaskPresenter
import com.barry.practicetogether.view.adapter.MyTaskAdapter
import com.barry.practicetogether.view.base.BaseActivity
import com.barry.practicetogether.view.iview.index.IMyTaskView
import kotlinx.android.synthetic.main.activity_my_task.*
import kotlinx.android.synthetic.main.include_toolbar.*


class MyTaskActivity : BaseActivity<IMyTaskView, MyTaskPresenter>(), IMyTaskView {
    companion object {
        fun startMyTaskActivity(context: Context) {
            context.startActivity(Intent(context, MyTaskActivity::class.java))
        }
    }


    private lateinit var myTaskAdapter: MyTaskAdapter
    override fun getTitleText(): String {
        return "我的作业"
    }

    override fun getLayout(): Int {
        return R.layout.activity_my_task
    }

    override fun initViews() {
        initToolbar(commToolBar)
        myTaskAdapter = MyTaskAdapter()
        rvMyTask.adapter = myTaskAdapter
    }

    override fun initData() {
        presenter?.myTaskList()
    }

    override fun createPresenter(): MyTaskPresenter? {
        return MyTaskPresenter()
    }

    override fun createView(): IMyTaskView? {
        return this
    }

    override fun setTask(list: List<MyTask>) {
        myTaskAdapter.setList(list)
    }


}