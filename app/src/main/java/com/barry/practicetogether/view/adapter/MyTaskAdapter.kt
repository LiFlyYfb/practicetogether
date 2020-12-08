package com.barry.practicetogether.view.adapter

import android.content.Context
import android.text.Layout
import android.text.SpannableString
import android.text.StaticLayout
import android.widget.TextView
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.MyTask
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *Created by Barry
 **/
@Suppress("NAME_SHADOWING")
class MyTaskAdapter : BaseQuickAdapter<MyTask, BaseViewHolder>(R.layout.item_my_task) {
    private val maxLine = 1
    private var eliString: SpannableString? = null
    private var notEliString: SpannableString? = null
    override fun convert(holder: BaseViewHolder, item: MyTask) {
        holder.setText(R.id.name, item.name)
        holder.setText(R.id.time, item.time)
        holder.setText(R.id.className, item.className)
        val tv = holder.getView<TextView>(R.id.tv)
        val tvSelect = holder.getView<TextView>(R.id.tvSelect)
        val content = item.content
        val paint = tv.paint
        val width: Int = context.resources.displayMetrics.widthPixels - dip2px(context, 0)
        val staticLayout =
            StaticLayout(content, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.1f, 0.0F, false)
        if (staticLayout.lineCount > maxLine) {
            val string1: String = content
            val index = staticLayout.getLineStart(maxLine) - 1
            val substring = content.substring(0, index) + "..."
            eliString = SpannableString(substring)
            tv.text = eliString
            tvSelect.setOnClickListener {
                notEliString = SpannableString(string1)
                eliString = SpannableString(substring)
                if (tv.isSelected) {
                    tvSelect.text = "收起"
                    tv.text = notEliString
                    tv.isSelected = false
                } else {
                    tvSelect.text = "展开"
                    tv.text = eliString
                    tv.isSelected = true
                }
            }
            tv.isSelected = true
        } else {
            tv.text = content
        }
    }
    private fun dip2px(mContext: Context, dpValue: Int): Int {
        val scale: Float = mContext.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

}