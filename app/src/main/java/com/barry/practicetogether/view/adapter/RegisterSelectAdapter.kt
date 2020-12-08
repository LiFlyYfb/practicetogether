package com.barry.practicetogether.view.adapter

import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.SelectClass
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *Created by Barry
 **/
class RegisterSelectAdapter : BaseQuickAdapter<SelectClass, BaseViewHolder>(R.layout.index_select) {
    override fun convert(holder: BaseViewHolder, item: SelectClass) {
        holder.setText(R.id.name, item.name)
    }
}