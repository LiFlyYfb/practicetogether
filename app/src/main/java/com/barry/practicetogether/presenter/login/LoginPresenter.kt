package com.barry.practicetogether.presenter.login

import com.barry.practicetogether.model.accountLogin
import com.barry.practicetogether.model.accountLogina
import com.barry.practicetogether.model.bean.Account
import com.barry.practicetogether.model.bean.LoginRest
import com.barry.practicetogether.model.bean.UserBean
import com.barry.practicetogether.model.saveAccount
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

    fun logina() {
        val loginBean = UserBean()
        loginBean.username = view!!.userId()
        loginBean.password = view!!.pwd()
        accountLogina(
            loginBean
        ).subscribe(object : Jobserver<LoginRest>(view) {
            override fun onSuccess(data: LoginRest?) {
                if (data != null) {
                    view?.success()
                    saveAccount(data)
                    //点击登录
                }
            }
        })
    }
}