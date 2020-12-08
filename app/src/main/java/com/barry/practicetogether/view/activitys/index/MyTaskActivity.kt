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
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_my_task)
//        val content =
//            """
//            在全球，随着Flutter被越来越多的知名公司应用在自己的商业APP中，Flutter这门新技术也逐渐进入了移动开发者的视野，尤其是当Google在2018年IO大会上发布了第一个Preview版本后，国内刮起来一股学习Flutter的热潮。
//
//            为了更好的方便帮助中国开发者了解这门新技术，我们，Flutter中文网，前后发起了Flutter翻译计划、Flutter开源计划，前者主要的任务是翻译Flutter官方文档，后者则主要是开发一些常用的包来丰富Flutter生态，帮助开发者提高开发效率。而时至今日，这两件事取得的效果还都不错！
//            """.trimIndent()
//        if (tv != null) {
//            tv.text = content
//        }
//        val paint = tv?.paint
//        val width: Int = resources.displayMetrics.widthPixels - dip2px(this, 0)
//        val staticLayout =
//            StaticLayout(content, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.1f, 0.0F, false)
//        if (staticLayout.lineCount > maxLine) {
//            val string1 = "$content"
//            notElipseString = SpannableString(string1)
//            val index = staticLayout.getLineStart(maxLine) - 1
//            val substring = content.substring(0, index) + "..."
//            elipseString = SpannableString(substring)
//            tv.text = elipseString
//            tvSelect?.setOnClickListener {
//                if (tv.isSelected) {
//                    tvSelect.text = "收起"
//                    if (tv != null) {
//                        tv.text = notElipseString
//                        tv.isSelected = false
//                    }
//                } else {
//                    tvSelect.text = "展开"
//                    if (tv != null) {
//                        tv.text = elipseString
//                        tv.isSelected = true
//                    }
//                }
//            }
//            if (tv != null) {
//                tv.isSelected = true
//            }
//        } else {
//            if (tv != null) {
//                tv.text = content
//            }
//        }
//
//    }

//    /**
//     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
//     */
//    fun dip2px(mContext: Context, dpValue: Int): Int {
//        val scale: Float = mContext.resources.displayMetrics.density
//        return (dpValue * scale + 0.5f).toInt()
//    }

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