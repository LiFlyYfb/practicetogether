package com.barry.practicetogether.view.adapter

import android.widget.TextView
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.Index3ClassBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_index2.view.*

/**
 *Created by Barry
 **/
class Index3ClassAdapter :
    BaseQuickAdapter<Index3ClassBean, BaseViewHolder>(R.layout.item_index2_class) {
    override fun convert(holder: BaseViewHolder, item: Index3ClassBean) {
        holder.setText(R.id.time, item.time)
        holder.setText(R.id.name, item.name)
        var view = holder.getView<TextView>(R.id.cls)
        view.text = when (item.classType) {
            "1" -> {
                "进入教室"
            }
            else -> {
                "查看回放"
            }
        }
    }
}