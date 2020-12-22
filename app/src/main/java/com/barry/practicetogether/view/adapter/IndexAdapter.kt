package com.barry.practicetogether.view.adapter

import android.widget.ImageView
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.IndexBean
import com.barry.practicetogether.utlis.PTGlide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *Created by Barry
 **/
class IndexAdapter : BaseQuickAdapter<IndexBean, BaseViewHolder>(R.layout.item_index) {
    override fun convert(holder: BaseViewHolder, item: IndexBean) {
        holder.setText(R.id.name, item.title)
        holder.setText(R.id.type, item.type)
        holder.setText(R.id.stdNum, item.stdNum)
        val view = holder.getView<ImageView>(R.id.classImg)
        PTGlide.load(context, view, item.img)
        holder.setText(R.id.time, item.time)
    }
}