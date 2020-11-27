package com.barry.basehttp

import android.app.Application
import okhttp3.Interceptor

abstract class BaseHttpApplication :Application(){
    abstract val baseUrl: String
    abstract val interceptors: Array<Interceptor>
    override fun onCreate() {
        super.onCreate()
        initHttp()
    }

    private fun initHttp() {
        BaseHttp.Builder()
            .init()
            .baseUrl(baseUrl)
            .addInterceptor(*interceptors)
            .builder()
    }
}