package com.barry.practicetogether.view.fragmnets.index2

import android.os.Bundle
import android.view.View
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnUseModelFragment

class Index2Fragment : BaseUnUseModelFragment() {
    companion object {
        val instance: Index2Fragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Index2Fragment()
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_index2
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }
}