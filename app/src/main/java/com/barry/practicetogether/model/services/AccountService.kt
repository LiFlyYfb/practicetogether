package com.barry.practicetogether.model.services

import com.barry.practicetogether.model.bean.Account
import com.barry.practicetogether.model.bean.LoginRest
import com.barry.practicetogether.model.bean.UserBean
import io.reactivex.Observable
import com.barry.practicetogether.model.bean.Result
import retrofit2.http.*

interface AccountService {


    @FormUrlEncoded
    @POST("shop/user/register")
    fun accountRegister(
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("verifyCode") verifyCode: String,
        @Field("insidePassword") insidePassword: String,
        @Field("inviteCode") inviteCode: String,
        @Field("type") type: Int = 0
    ): Observable<Result<Account>>


    @FormUrlEncoded
    @POST("yiqilian/stu/login")
    fun accountLogin(
        @Field("username") loginName: String,
        @Field("password") password: String
    ): Observable<Result<Account>>

    @FormUrlEncoded
    @POST("shop/user/msglogin")
    fun verCodeLogin(
        @Field("phone") phone: String,
        @Field("verifyCode") verifyCode: String
    ): Observable<Result<Account>>

    @FormUrlEncoded
    @POST("shop/user/forgetPassword")
    fun resetPassword(
        @Field("phone") phone: String,
        @Field("newPassword") newPassword: String,
        @Field("verifyCode") verifyCode: String,
        @Field("loginName") loginName: String
    ): Observable<Result<Any>>

    @POST("yiqilian/stu/login")
    fun rLogin(@Body userBean: UserBean): Observable<Result<LoginRest>>


    @POST("shop/user/logout")
    fun logout(): Observable<Result<String>>


}