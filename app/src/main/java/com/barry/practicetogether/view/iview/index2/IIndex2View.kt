package com.barry.practicetogether.view.iview.index2

import com.barry.practicetogether.model.bean.Index3ClassBean
import com.barry.practicetogether.view.iview.IBaseView

/**
 *Created by Barry
 **/
interface IIndex2View : IBaseView {
    fun setData(): String
    fun setList(list: List<Index3ClassBean>)
}