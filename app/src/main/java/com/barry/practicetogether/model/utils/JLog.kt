package com.barry.practicetogether.model.utils

import android.util.Log
import com.barry.basehttp.BuildConfig

fun logd(msg: String, tag: String = "zeus") {
    if (BuildConfig.DEBUG) {
        Log.d(tag, msg)
    }
}

fun loge(msg: String, tag: String = "zeus") {
    if (BuildConfig.DEBUG) {
        Log.e(tag, msg)
    }
}

fun logi(msg: String, tag: String = "zeus") {
    if (BuildConfig.DEBUG) {
        Log.i(tag, msg)
    }
}