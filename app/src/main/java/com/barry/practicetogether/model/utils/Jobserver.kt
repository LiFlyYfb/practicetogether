package com.barry.practicetogether.model.utils

import com.barry.practicetogether.view.iview.IBaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.barry.practicetogether.model.bean.Result


abstract class Jobserver<T> @JvmOverloads constructor(
    private var view: IBaseView?,
    private var isShowLoading: Boolean = true
) : Observer<Result<T>> {

    override fun onSubscribe(d: Disposable) {
        if (isShowLoading) {
            view?.startLoading()
        }
    }

    override fun onNext(data: Result<T>) {
        if (isShowLoading) {
            view?.endLoading()
        }
        if (data.code == HTTP_OK) {
            onSuccess(data.data)
        } else {
            onError(data.code, data.msg)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (isShowLoading) {
            view?.endLoading()
        }
        onError(-1, JException.handleException(e).message)
    }

    override fun onComplete() {
        if (isShowLoading) {
            view?.endLoading()
        }
    }

    /**
     * 请求成功回调
     *
     * @param data
     */
    abstract fun onSuccess(data: T?)

    private fun onError(code: Int, msg: String?) {
        if (msg != null) {
            loge(msg)
            view?.onError(code, msg)
        } else {
            loge("未知错误")
            view?.onError(code, "未知错误")
        }
    }

    companion object {
        const val HTTP_OK = 0
    }
}
