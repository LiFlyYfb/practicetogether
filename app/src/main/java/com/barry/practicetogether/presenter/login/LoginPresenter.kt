package com.barry.practicetogether.presenter.login

import com.barry.practicetogether.model.accountLogin
import com.barry.practicetogether.model.bean.Account
import com.barry.practicetogether.model.utils.Jobserver
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.login.ILoginView

class LoginPresenter : BasePresenter<ILoginView>() {
    fun login() {
        accountLogin(
            view!!.userId(),
            view!!.pwd()
        ).subscribe(object : Jobserver<Account>(view) {
            override fun onSuccess(data: Account?) {
                //可以在此处保存登录数据
                view?.success()
            }
        })
    }
}