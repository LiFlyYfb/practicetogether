package com.barry.practicetogether.utlis


fun offsetTime(start: Long, end: Long): String {
    var str = ""
    var duration = (end - start) / 1000
    str += if (duration / 60 > 10) duration / 60 else "0${duration / 60}"
    str += ":"
    duration %= 60
    str += if (duration >= 10) duration else "0${duration}"
    return str
}