package com.barry.practicetogether.model.services

import com.barry.practicetogether.model.bean.Account
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.barry.practicetogether.model.bean.Result

interface AccountService {

    @FormUrlEncoded
    @POST("shop/user/sendMessage")
    fun sendSms(
        @Field("phone") phone: String,
        @Field("vaptchaToken") token: String,
        @Field("type") type: Int = 0,
        @Field("reg_time") reg_time: Long = System.currentTimeMillis()
    ): Observable<Result<Any>>

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
    @POST("shop/user/login")
    fun accountLogin(
        @Field("loginName") loginName: String,
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


    @POST("shop/user/logout")
    fun logout(): Observable<Result<Any>>





}