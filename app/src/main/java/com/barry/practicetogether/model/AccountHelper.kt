package com.barry.practicetogether.model

import com.barry.basehttp.BaseHttp
import com.barry.practicetogether.model.bean.Account
import com.barry.practicetogether.model.bean.LoginRest
import com.barry.practicetogether.model.bean.Result
import com.barry.practicetogether.model.bean.UserBean
import com.barry.practicetogether.model.services.AccountService
import com.barry.practicetogether.model.utils.TokenException
import com.barry.practicetogether.model.utils.ioMain
import com.barry.practicetogether.model.utils.logd
import com.barry.practicetogether.utlis.*
import io.reactivex.Observable

val accountService = BaseHttp.instance.buildService(AccountService::class.java)

//保存数据
fun saveAccount(account: LoginRest) {
    put("accountId", toBase64(account.phone))
//    put("token", toBase64(account.token))
    put("token", account.token)
    putObject("account", account)
}

fun getAccountId(): String {
    val id = fromBase64(getString("accountId", ""))
    logd(id)
    return id
}

fun getToken(): String {
//    val token = fromBase64(getString("token", ""))
    val token = getString("token", "")
    logd(token)
    return token
}

fun getAccount(): Account? {

    return getObject<Account>("account")
}

/**
 * 邮箱注册
 * [email] 邮箱
 * [pwd] 密码
 * [verifyCode] 验证码
 * [payPassword] 支付密码
 * [inviteCode] 邀请码
 */
fun emailRegister(
    email: String,
    pwd: String,
    verifyCode: String,
    payPassword: String,
    inviteCode: String
): Observable<Result<Account>> {

    if (email.isEmpty()) {
        return Observable.create {
            it.onNext(Result(TokenException.EMAIL_EMPTY.code, TokenException.EMAIL_EMPTY.message))
        }
    }
    return accountService.accountRegister(
        email,
        toBase64(pwd),
        verifyCode,
        toBase64(payPassword),
        inviteCode,
        1
    )
        .compose(ioMain())
}

/**
 *账号登录
 * [loginName] 账号
 * [pwd] 密码
 */
fun accountLogin(loginName: String, pwd: String): Observable<Result<Account>> {
    if (loginName.isEmpty()) {
        return Observable.create {
            it.onNext(
                Result(
                    TokenException.LOGIN_NAME_EMPTY.code,
                    TokenException.LOGIN_NAME_EMPTY.message
                )
            )
        }
    }
    return accountService.accountLogin(loginName, toBase64(pwd)).compose(ioMain())
}

fun accountLogina(userBean: UserBean): Observable<Result<LoginRest>> {
    if (userBean.username.isEmpty()) {
        return Observable.create {
            it.onNext(
                Result(
                    TokenException.LOGIN_NAME_EMPTY.code,
                    TokenException.LOGIN_NAME_EMPTY.message
                )
            )
        }
    }
    if (userBean.password.isEmpty()) {
        return Observable.create {
            it.onNext(
                Result(
                    TokenException.LOGIN_PWD_EMPTY.code,
                    TokenException.LOGIN_PWD_EMPTY.message
                )
            )
        }
    }
    return accountService.rLogin(userBean).compose(ioMain())
}





