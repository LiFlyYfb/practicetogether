package com.barry.practicetogether.view.iview.login

import com.barry.practicetogether.view.iview.IBaseView

interface ILoginView : IBaseView {
    fun userId(): String
    fun pwd(): String
    fun success()
}