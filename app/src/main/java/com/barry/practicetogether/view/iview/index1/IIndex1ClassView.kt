package com.barry.practicetogether.view.iview.index1

import com.barry.practicetogether.model.bean.Index1ClassBean
import com.barry.practicetogether.view.iview.IBaseView

/**
 *Created by Barry
 **/
interface IIndex1ClassView : IBaseView {
    fun setClass(list: List<Index1ClassBean>)
    fun type(): String
}