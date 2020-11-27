package com.barry.practicetogether.presenter.index1

import com.barry.practicetogether.model.bean.Index1ClassBean
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.index1.IIndex1ClassView

/**
 *Created by Barry
 **/
class Index1ClassPresenter : BasePresenter<IIndex1ClassView>() {
    private var classlist: MutableList<Index1ClassBean> = ArrayList()

    fun data(type: String) {
        classlist.clear()
        when (type) {
            "1" -> {
                for (index in 0..5) {
                    var bannerBean = Index1ClassBean()
                    bannerBean.name = "李老师上课名称${index}"
                    bannerBean.num = "$index"
                    bannerBean.time = "开课时间${index}"
                    bannerBean.type = "3"
                    classlist.add(bannerBean)
                }
            }
            else -> {
                for (index in 0..3) {
                    var bannerBean = Index1ClassBean()
                    bannerBean.name = "田阔老师上课名称${index}"
                    bannerBean.num = "$index"
                    bannerBean.time = "开课时间${index}"
                    bannerBean.type = "${index / 2}"
                    classlist.add(bannerBean)
                }
            }
        }

    }

    fun getClass() {
        data(view!!.type())
        view!!.setClass(classlist)
    }
}