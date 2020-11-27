package com.barry.practicetogether.view.fragmnets.index1

import android.os.Bundle
import android.view.View
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.Index1ClassBean
import com.barry.practicetogether.presenter.index1.Index1ClassPresenter
import com.barry.practicetogether.view.adapter.IndexClassAdapter
import com.barry.practicetogether.view.base.BaseFragment
import com.barry.practicetogether.view.iview.index1.IIndex1ClassView
import kotlinx.android.synthetic.main.fragment_class.*

/**
 *Created by Barry
 **/
abstract class BaseClassFragment : BaseFragment<IIndex1ClassView, Index1ClassPresenter>(),
    IIndex1ClassView {

    override fun getLayout(): Int {
        return R.layout.fragment_class
    }

    lateinit var indexClassAdapter: IndexClassAdapter
    override fun initView(view: View, savedInstanceState: Bundle?) {
        indexClassAdapter = IndexClassAdapter()
        rvClassFragment.adapter = indexClassAdapter
    }

    override fun createPresenter(): Index1ClassPresenter? {
        return Index1ClassPresenter()
    }


    override fun createView(): IIndex1ClassView? {
        return this
    }

    override fun initData() {
        presenter?.getClass()
    }

    override fun setClass(list: List<Index1ClassBean>) {
        indexClassAdapter.setList(list)
    }


}