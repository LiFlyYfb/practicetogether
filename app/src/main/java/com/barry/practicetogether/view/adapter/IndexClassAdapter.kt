package com.barry.practicetogether.view.adapter

import android.widget.TextView
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.Index1ClassBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *Created by Barry
 **/
class IndexClassAdapter :
    BaseQuickAdapter<Index1ClassBean, BaseViewHolder>(R.layout.item_index1_class) {
    override fun convert(holder: BaseViewHolder, item: Index1ClassBean) {
        holder.setText(R.id.classNum, item.num)
        holder.setText(R.id.time, item.time)
        holder.setText(R.id.name, item.name)
        var view = holder.getView<TextView>(R.id.cls)
        when (item.type) {
            "1" -> {
                view.text = "去上课"
                view.setBackgroundResource(R.drawable.login_btn)
            }
            "3" -> {
                view.text = "已结束"
                view.setBackgroundResource(R.drawable.login_bg)
            }
            "0" -> {
                view.text = "未开始"
                view.setBackgroundResource(R.drawable.login_bg)
            }
        }
    }
}