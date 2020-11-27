package com.barry.practicetogether.view.iview

interface IBaseView {
    fun onError(code: Int, msg: String)
    val filePath: String
    fun startLoading()
    fun endLoading()
}