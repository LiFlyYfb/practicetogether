package com.barry.basehttp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseHttp {
    companion object {
        val instance: BaseHttp by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            BaseHttp()
        }
    }

    private var retrofit: Retrofit? = null
    fun init(builder: Builder) {
        val gson = initGson()
        val okHttpClient = initOkhttp(builder.interceptors)
        retrofit = Retrofit.Builder()
            .baseUrl(builder.baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    private fun initGson(): Gson {
        return GsonBuilder()
//            .registerTypeAdapter(Double::class.java,DoubleType())
//            .registerTypeAdapter(Int::class.java,IntType())
//            .registerTypeAdapter(Float::class.java,FloatType())
//            .registerTypeAdapter(Long::class.java,LongType())
            .create()
    }

    private fun initOkhttp(interceptor: ArrayList<Interceptor>): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(1, TimeUnit.MINUTES)
        builder.writeTimeout(1, TimeUnit.MINUTES)
        builder.connectTimeout(1, TimeUnit.MINUTES)
        interceptor.forEach {
            builder.addInterceptor(it)
        }
        builder.addInterceptor(initHttpLog())
        return builder.build()
    }

    private fun initHttpLog(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }


    fun <T> buildService(serviceClass: Class<T>): T {
        if (retrofit == null) {
            throw NullPointerException("retrofit 没有初始化")
        }
        return retrofit!!.create(serviceClass)
    }

    class Builder {
        var baseUrl = ""
        var interceptors: ArrayList<Interceptor> = ArrayList()

        fun init():Builder{
            return this
        }
        fun baseUrl(baseUrl: String): Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun addInterceptor(vararg interceptor: Interceptor): Builder {
            interceptor.forEach {
                interceptors.add(it)
            }
            return this
        }

        fun builder() {
            instance.init(this)
        }
    }

}