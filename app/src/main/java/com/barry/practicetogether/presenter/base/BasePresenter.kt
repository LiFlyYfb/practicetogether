package com.barry.practicetogether.presenter.base

import com.barry.practicetogether.view.iview.IBaseView
import java.lang.ref.SoftReference

abstract class BasePresenter<V : IBaseView> {
    private var softReference: SoftReference<V>? = null

    fun bind(view: V?) {
        if (view==null){
            return
        }
        softReference = SoftReference(view)
    }

    fun unBind() {
        softReference?.clear()
    }

    val view: V?
        get() {
            return if (softReference == null) {
                null
            } else {
                softReference?.get()
            }
        }
}