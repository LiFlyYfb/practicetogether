package com.barry.practicetogether.model.bean

class Result<T>(var code: Int, var msg: String?) {
    var data: T? = null

    override fun toString(): String {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\''.toString() +
                ", data=" + data +
                '}'.toString()
    }
}
