package com.barry.practicetogether.model.utils

import android.content.Context
import com.barry.practicetogether.model.getToken
import okhttp3.*
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.*
import kotlin.collections.HashMap

class RequestInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.method == GET) {
//            request = addGetParams(request)
        } else if (request.method == POST) {
//            request = addPostParams(request)
//            request = addGetParams(request)
        }
        val build =
            request.newBuilder().addHeader("token", getToken()).url(request.url.newBuilder().build())
                .build()
        return chain.proceed(build)
    }

    private fun addGetParams(request: Request): Request {
        var httpUrl = request.url
            .newBuilder()
            .addQueryParameter("deviceType", deviceType)
//            .addQueryParameter("deviceUuid", getDeviceUUID(context))
//            .addQueryParameter("systemVersion", systemVersion)
//            .addQueryParameter("appVersion", appVersion)
//            .addQueryParameter("timeStamp", timestamp.toString())
//            .addQueryParameter("systemType", systemType)
//            .addQueryParameter("clientIp", getIPAddress(context))
////            .addQueryParameter("pkgId", BuildConfig.APPLICATION_ID)
//            .addQueryParameter("lang", "zh_cn")
//            .addQueryParameter("timeStamp", System.currentTimeMillis().toString())
//            .addQueryParameter("userId", getAccountId())
            .addQueryParameter("token", getToken())
            .build()
        val nameSet = httpUrl.queryParameterNames
        val nameList = ArrayList(nameSet)
        nameList.sort()
        val buffer = StringBuilder()
        for (i in nameList.indices) {
            buffer.append(nameList[i])
                .append("=")
                .append(httpUrl.queryParameter(nameList[i]))
                .append("&")
        }

        if (buffer.isNotEmpty()) {
            buffer.deleteCharAt(buffer.length - 1)
        }

        buffer.append(SALTSTR)
        httpUrl = httpUrl.newBuilder()
            .addQueryParameter("sign", MD5Util.md5encode(buffer.toString(), "UTF-8"))
            .build()
        return request.newBuilder().url(httpUrl).build()
    }

    @Throws(UnsupportedEncodingException::class)
    private fun addPostParams(request: Request): Request {
        return request.newBuilder().post(formRequest(request)).build()
    }

    private fun formRequest(request: Request): FormBody {
        val bodyBuilder = FormBody.Builder()
        var formBody: FormBody
        if (request.body is FormBody) {
            formBody = request.body as FormBody
            for (i in 0 until formBody.size) {
                bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i))
            }
        }
        bodyBuilder.addEncoded("deviceType", deviceType)
//            .addEncoded("deviceUuid", getDeviceUUID(context))
//            .addEncoded("systemVersion", systemVersion)
//            .addEncoded("appVersion", appVersion)
//            .addEncoded("timestamp", timestamp.toString())
//            .addEncoded("systemType", systemType)
//            .addEncoded("clientIp", getIPAddress(context))
//            .addEncoded("pkgId", "BuildConfig.APPLICATION_ID")
//            .addEncoded("lang", "zh_cn")
//            .addEncoded("timeStamp", System.currentTimeMillis().toString())
//            .addEncoded("userId", getAccountId())
//            .addEncoded("token", getToken())

        formBody = bodyBuilder.build()

        val boyMap = TreeMap<String, String>()

        for (i in 0 until formBody.size) {
            val encodeName = URLDecoder.decode(formBody.encodedName(i), "UTF-8")
            val encodeValue = URLDecoder.decode(formBody.encodedValue(i), "UTF-8")
            boyMap[encodeName] = encodeValue
        }

        val sign = SignUtil.joinSign(boyMap)

        return bodyBuilder.addEncoded("sign", sign!!)
            .build()
    }

    companion object {
        const val SALTSTR = "06fb7dcb9d4248c5b3bfa5cea9d2000"
        private const val POST = "POST"
        private const val GET = "GET"
    }

}
