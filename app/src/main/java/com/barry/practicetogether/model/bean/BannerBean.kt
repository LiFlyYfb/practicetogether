package com.barry.practicetogether.model.bean

import com.stx.xhb.androidx.entity.SimpleBannerInfo

/**
 *Created by Barry
 **/
class BannerBean : SimpleBannerInfo() {
    var banne = "1"
    override fun getXBannerUrl(): Any {
        return banne
    }

}