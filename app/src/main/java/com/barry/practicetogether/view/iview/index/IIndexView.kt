package com.barry.practicetogether.view.iview.index

import com.barry.practicetogether.model.bean.BannerBean
import com.barry.practicetogether.model.bean.IndexBean
import com.barry.practicetogether.view.iview.IBaseView

/**
 *Created by Barry
 **/
interface IIndexView : IBaseView {
    fun setBanner(list: List<BannerBean>)
    fun setClassShow(list: List<IndexBean>)
}