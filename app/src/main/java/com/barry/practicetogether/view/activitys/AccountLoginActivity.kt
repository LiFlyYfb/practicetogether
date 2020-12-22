package com.barry.practicetogether.view.activitys

import JClickListener
import com.barry.practicetogether.R
import com.barry.practicetogether.presenter.login.LoginPresenter
import com.barry.practicetogether.view.MainActivity
import com.barry.practicetogether.view.base.BaseActivity
import com.barry.practicetogether.view.iview.login.ILoginView
import kotlinx.android.synthetic.main.activity_account_login.*

class AccountLoginActivity : BaseActivity<ILoginView, LoginPresenter>(), ILoginView {
    override fun getLayout(): Int {
        return R.layout.activity_account_login
    }

    override fun initViews() {
        btnLogin.setOnClickListener {
//            MainActivity.startMainActivity(this)
            presenter?.logina()
        }
        btnRegister.setOnClickListener(JClickListener {

            RegisterActivity.startRegisterActivity(this)
        })
    }

    override fun initData() {

    }

    override fun createPresenter(): LoginPresenter? {
        return LoginPresenter()
    }

    override fun createView(): ILoginView? {
        return this
    }

    override fun userId(): String {
        return edAccount.text.toString().trim()
    }

    override fun pwd(): String {
        return edPwd.text.toString().trim()
    }

    override fun success() {
        MainActivity.startMainActivity(this)
    }
}