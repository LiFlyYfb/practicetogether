package com.barry.practicetogether.view.fragmnets.index2

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.Toast
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.Index3ClassBean
import com.barry.practicetogether.presenter.insex2.Index2ClassPresenter
import com.barry.practicetogether.view.adapter.Index3ClassAdapter
import com.barry.practicetogether.view.base.BaseFragment
import com.barry.practicetogether.view.base.BaseUnUseModelFragment
import com.barry.practicetogether.view.iview.index2.IIndex2View
import kotlinx.android.synthetic.main.fragment_index2.*

class Index2Fragment : BaseFragment<IIndex2View, Index2ClassPresenter>(), IIndex2View {
    companion object {
        val instance: Index2Fragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Index2Fragment()
        }
    }

    lateinit var index3ClassAdapter: Index3ClassAdapter
    override fun getLayout(): Int {
        return R.layout.fragment_index2
    }

    var str = ""
    override fun initView(view: View, savedInstanceState: Bundle?) {
        calendarViewId.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            val timeStr: String = "$year-${month + 1}-$dayOfMonth"
            showToast(timeStr)
            str = timeStr
            presenter?.getClassData()
        })
        index3ClassAdapter = Index3ClassAdapter()
        rv.adapter = index3ClassAdapter
    }

    override fun initData() {
        presenter?.getClassData()
    }

    override fun createPresenter(): Index2ClassPresenter? {
        return Index2ClassPresenter()
    }

    override fun createView(): IIndex2View? {
        return this
    }

    override fun setData(): String {
//        showToast(str)
        return str
    }

    override fun setList(list: List<Index3ClassBean>) {
        index3ClassAdapter.setList(list)
        index3ClassAdapter.notifyDataSetChanged()
    }
}


