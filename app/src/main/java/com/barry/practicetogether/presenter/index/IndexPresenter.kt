package com.barry.practicetogether.presenter.index

import com.barry.practicetogether.model.bean.BannerBean
import com.barry.practicetogether.model.bean.IndexBean
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.index.IIndexView

/**
 *Created by Barry
 **/
class IndexPresenter : BasePresenter<IIndexView>() {
    private var bannerlist: MutableList<BannerBean> = ArrayList()
    private var classlist: MutableList<IndexBean> = ArrayList()
    var ban =
        listOf<String>(
            "https://seopic.699pic.com/photo/40006/5893.jpg_wh1200.jpg",
            "https://seopic.699pic.com/photo/50063/3943.jpg_wh1200.jpg",
            "https://seopic.699pic.com/photo/50055/7604.jpg_wh1200.jpg",
            "https://seopic.699pic.com/photo/50035/0237.jpg_wh1200.jpg",
            "https://seopic.699pic.com/photo/40006/2979.jpg_wh1200.jpg",
            "https://seopic.699pic.com/photo/40006/2979.jpg_wh1200.jpg"
        )

    fun data() {
        classlist.clear()
        bannerlist.clear()
        for (index in 0..5) {
            var bannerBean = BannerBean()
            bannerBean.banne = ban[index]
            bannerlist.add(bannerBean)
        }
        for (index in 0..5) {
            var bannerBean = IndexBean()
            bannerBean.time = "1212121221"
            bannerBean.title = "名称钢琴${index}"
            bannerBean.type = "钢琴${index}"
            bannerBean.stdNum = "111${index}"
            bannerBean.img = ban[index]
            classlist.add(bannerBean)
        }
    }

    fun getBanner() {
        data()
        view!!.setBanner(bannerlist)
    }

    fun getClass() {
        view!!.setClassShow(classlist)
    }
}