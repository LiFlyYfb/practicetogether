package com.barry.practicetogether

import android.app.Activity
import android.os.Bundle
import com.barry.basehttp.BaseHttpApplication

import com.barry.practicetogether.model.utils.RequestInterceptor
import com.barry.practicetogether.model.utils.URLInterceptor
import com.barry.practicetogether.model.utils.logd
import com.barry.practicetogether.utlis.init
import okhttp3.Interceptor


class MyApplication : BaseHttpApplication() {
    override val baseUrl: String
        get() = BuildConfig.API_URL
    override val interceptors: Array<Interceptor>
        get() = arrayOf(RequestInterceptor(this))

    override fun onCreate() {
        super.onCreate()
        init(this)
        registerActivityLifecycleCallbacks(lifecycleCallback)
    }

    companion object {
        private var activitys: ArrayList<Activity> = arrayListOf()
        fun clearActivityTask() {
            for (a in activitys) {
                a.finish()
            }
            activitys.clear()
        }
    }

    private val lifecycleCallback = object : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            if (activity != null) {
                logd("111111111111111111111111111111111111")
                activitys.remove(activity)
            }
        }

    }
}