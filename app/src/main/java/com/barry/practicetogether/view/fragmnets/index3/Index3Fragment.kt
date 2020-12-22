package com.barry.practicetogether.view.fragmnets.index3

import android.os.Bundle
import android.view.View
import com.barry.practicetogether.R
import com.barry.practicetogether.view.activitys.index3.RecordSoundActivity
import com.barry.practicetogether.view.base.BaseUnUseModelFragment
import kotlinx.android.synthetic.main.fragment_index3.*


class Index3Fragment : BaseUnUseModelFragment() {
    companion object {
        val instance: Index3Fragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Index3Fragment()
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_index3
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        ss.setOnClickListener { RecordSoundActivity.startRecordSoundActivity(mContext) }
    }

    override fun initData() {
    }
}