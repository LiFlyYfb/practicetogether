package com.barry.practicetogether.model.utils

import android.util.Log
import okhttp3.FormBody
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response

class URLInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val headerValues = request.headers("baseurl")
        if (headerValues != null && headerValues.isNotEmpty()) {
            var pBaseUrl = ""
            val formBody = request.body as FormBody
            for (i in 0 until formBody.size){
               val  name = formBody.name(i)
                Log.d("1111111", "intercept: ${name}")
                if (name=="baseurl"){
                    pBaseUrl = formBody.value(i)
                    Log.d("1111111", "intercept: ${pBaseUrl}")
                    break
                }
            }

            builder.removeHeader("baseurl")
            val oldHttpUrl = request.url
            val headerValue = headerValues[0]
            val newBaseUrl = if ("user" == headerValue) {
                pBaseUrl.toHttpUrlOrNull()
            } else {
                oldHttpUrl
            }

            val newFullUrl = oldHttpUrl
                .newBuilder()
                .scheme(newBaseUrl!!.scheme)
                .host(newBaseUrl.host)
                .port(newBaseUrl.port)
                .build()
            return chain.proceed(builder.url(newFullUrl).build());
        }
        return chain.proceed(request)
    }
}