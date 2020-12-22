package com.barry.practicetogether.model.utils

import android.net.ParseException
import com.bumptech.glide.load.HttpException
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

class JException(var code: Int, override var message: String) : Exception() {

    companion object {
        fun handleException(exception: Throwable): TokenException {
            return when (exception) {
                is HttpException -> {
                    TokenException.HTTP_ERROR
                }

                is SocketTimeoutException,
                is ConnectTimeoutException -> {
                    TokenException.TIME_OUT
                }

                is ConnectException,
                is UnknownHostException -> {
                    TokenException.CONNECT_ERROR
                }

                is SSLHandshakeException -> {
                    TokenException.SSL_ERROR
                }

                is JsonParseException,
                is JSONException,
                is ParseException -> {
                    TokenException.JSON_ERROR
                }

                else -> {
                    TokenException.UNKNOW
                }
            }
        }
    }

}

enum class TokenException(var code: Int, var message: String) {
    UNKNOW(-1000, "未知错误"),
    HTTP_ERROR(-11, "服务器异常"),
    TIME_OUT(-12, "服务器连接超时，请重试"),
    CONNECT_ERROR(-13, "服务器连接失败，请重试"),
    SSL_ERROR(-14, "证书异常"),
    JSON_ERROR(-15, "数据异常"),
    EMAIL_EMPTY(-16, "数据异常"),
    LOGIN_NAME_EMPTY(-18, "用户名为空"),
    LOGIN_PWD_EMPTY(-19, "密码为空"),
}