package com.barry.practicetogether.presenter.insex2

import com.barry.practicetogether.model.bean.Index1ClassBean
import com.barry.practicetogether.model.bean.Index3ClassBean
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.index2.IIndex2View

/**
 *Created by Barry
 **/
class Index2ClassPresenter : BasePresenter<IIndex2View>() {
    var list: MutableList<Index3ClassBean> = arrayListOf()

    fun getClassData() {
        dat(view!!.setData())
        view!!.setList(list)
    }

    fun dat(str: String) {
        list.clear()
        when (str) {
            "2020-11-29" -> {
                for (index in 0..3) {
                    var bannerBean = Index3ClassBean()
                    bannerBean.name = "田阔老师课称${index}"
                    bannerBean.time = "开课时间${index}"
                    bannerBean.classType = "${index / 2}"
                    list.add(bannerBean)
                }
            }
            "2020-11-30" -> {
                for (index in 0..5) {
                    var bannerBean = Index3ClassBean()
                    bannerBean.name = "李老师课称${index}"
                    bannerBean.time = "开课时间${index}"
                    bannerBean.classType = "${index / 2}"
                    list.add(bannerBean)
                }
            }
            else -> {
                for (index in 0..10) {
                    var bannerBean = Index3ClassBean()
                    bannerBean.name = "你的所有课程${index}"
                    bannerBean.time = "开课时间${index}"
                    bannerBean.classType = "${index / 2}"
                    list.add(bannerBean)
                }
            }
        }
    }

}