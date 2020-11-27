package com.barry.practicetogether.model.utils

import java.security.MessageDigest

/**
 * @author:JUNE
 * @date:2020/3/20 14:13
 * @discription:
 */
object MD5Util {

    private val HEX_DIGITS =
        arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")

    fun md5encode(origin: String, charsetname: String?): String {
        var resultString = ""
        try {
            resultString = origin
            val md = MessageDigest.getInstance("MD5")
            resultString = if (charsetname == null || "" == charsetname) {
                byteArrayToHexString(
                    md.digest(
                        resultString
                            .toByteArray()
                    )
                )
            } else {
                byteArrayToHexString(
                    md.digest(
                        resultString
                            .toByteArray(charset(charsetname))
                    )
                )
            }

        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return resultString
    }


    private fun byteArrayToHexString(b: ByteArray): String {
        val resultSb = StringBuilder()
        for (aB in b) {
            resultSb.append(byteToHexString(aB))
        }
        return resultSb.toString()
    }

    private fun byteToHexString(b: Byte): String {
        var n = b.toInt()
        if (n < 0) {
            n += 256
        }
        val d1 = n / 16
        val d2 = n % 16
        return HEX_DIGITS[d1] + HEX_DIGITS[d2]
    }
}
