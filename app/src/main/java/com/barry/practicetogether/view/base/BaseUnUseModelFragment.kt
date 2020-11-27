package com.barry.practicetogether.view.base

import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.IBaseView

abstract class BaseUnUseModelFragment : BaseFragment<IBaseView, BasePresenter<IBaseView>>() {

    override fun createPresenter(): BasePresenter<IBaseView>? {
        return null
    }

    override fun createView(): IBaseView? {
        return null
    }

}