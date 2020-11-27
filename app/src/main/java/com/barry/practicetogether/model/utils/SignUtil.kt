package com.barry.practicetogether.model.utils

import com.barry.practicetogether.model.utils.MD5Util.md5encode
import com.barry.practicetogether.model.utils.RequestInterceptor.Companion.SALTSTR
import java.util.*

object SignUtil {
    @JvmStatic
    fun joinSign(map: TreeMap<String, String>): String? {
        val sb = StringBuilder()
        val es: Set<*> = map.entries
        for (e in es) {
            val entry = e as Map.Entry<*, *>
            val k = entry.key as String
            val v = entry.value
//            if ("sign" != k) {
            sb.append(k)
                .append("=")
                .append(v)
                .append("&")
//            }
        }
        val c = "${sb}key=$SALTSTR"
        return md5encode(c, "UTF-8")
    }
}