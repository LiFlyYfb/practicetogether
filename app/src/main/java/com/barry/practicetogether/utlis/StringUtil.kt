package com.barry.practicetogether.utlis


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Base64
import java.text.SimpleDateFormat

fun toBase64(str: String): String {
    return Base64.encode(str.toByteArray(), Base64.NO_WRAP).toString(Charsets.UTF_8)
}

fun fromBase64(base64:String):String{
    return Base64.decode(base64,Base64.NO_WRAP).toString(Charsets.UTF_8)
}

fun isEmail(email: String): Boolean {
    val regexEmail =
        "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
    val regex = Regex(regexEmail)
    return email.matches(regex)
}

fun isPhone(str: String): Boolean {
    val telRegexc =
        "^(0|86|17951)?(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$"
    val regex = Regex(telRegexc)
    return str.matches(regex)
}

fun isEthAddress(address:String):Boolean{
//    val addressRegexc = "^(0T|0x|0X)?[0-9a-fA-F]{40}\$"
    val addressRegexc = "^(0T)?[0-9a-fA-F]{40}\$"
    val regex = Regex(addressRegexc)
    return address.matches(regex)
}

fun isLoginName(str: String): Boolean {
    val telRegexc =
        "^([az])+([0-9]{6})$"
    val regex = Regex(telRegexc)
    return str.matches(regex)
}

fun copy(context: Context, content: String) {
    val cm = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    cm.setPrimaryClip(ClipData.newPlainText(null, content))
}

fun long2Str(time: Long): String {
    val format = SimpleDateFormat("mm:ss")
    return format.format(time)
}

