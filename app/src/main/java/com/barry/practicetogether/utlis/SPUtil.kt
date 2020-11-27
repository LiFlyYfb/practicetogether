package com.barry.practicetogether.utlis

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


private var sharedPreferences: SharedPreferences? = null
private var editor: SharedPreferences.Editor? = null
private val spname = "zeus"

@SuppressLint("CommitPrefEdits")
fun init(context: Context) {
    sharedPreferences = context.getSharedPreferences(spname, Context.MODE_PRIVATE)
    editor = sharedPreferences!!.edit()
}


fun put(key: String, value: Any) {
    when (value.javaClass.simpleName) {
        "Integer" -> editor!!.putInt(key, value as Int)
        "Boolean" -> editor!!.putBoolean(key, value as Boolean)
        "String" -> editor!!.putString(key, value as String)
        "Float" -> editor!!.putFloat(key, value as Float)
        "Long" -> editor!!.putLong(key, value as Long)
    }
    editor!!.commit()
}

fun putObject(key: String, value: Any) {
    val json = Gson().toJson(value)
    put(key, toBase64(json))
}


fun remove() {
    editor?.remove("accountId")
    editor?.remove("token")
    editor?.remove("account")
    editor?.commit()
}

fun removeAll() {
    editor?.remove("accountId")
    editor?.remove("token")
    editor?.remove("account")
    editor!!.clear()
    editor!!.commit()
}

inline fun <reified T : Any> getObject(key: String): T {
    val base64json = getString(key, "")
    val json = fromBase64(base64json)
    return Gson().fromJson<T>(json, T::class.java)
//    try {
//        val obj64 = getString(key, "") ?: return null
//
//        if (obj64.isEmpty()) {
//            return null
//        }
//        val base64Bytes = Base64.decode(obj64, Base64.DEFAULT)
//        val bais = ByteArrayInputStream(base64Bytes)
//        val ois = ObjectInputStream(bais)
//        return ois.readObject() as T
//    } catch (e: StreamCorruptedException) {
//        e.printStackTrace()
//    } catch (e: OptionalDataException) {
//        e.printStackTrace()
//    } catch (e: IOException) {
//        e.printStackTrace()
//    } catch (e: ClassNotFoundException) {
//        e.printStackTrace()
//    }
//
//    return null
}


fun getString(key: String, defValue: String): String {
    return (get(key, defValue) as String)
}

fun getInt(key: String, defValue: Int): Int {
    return get(key, defValue) as Int
}

fun getLong(key: String, defValue: Long): Long {
    return get(key, defValue) as Long
}


fun getFloat(key: String, defValue: Float): Float {
    return get(key, defValue) as Float
}

fun getDouble(key: String, defValue: Double): Double {
    return get(key, defValue) as Double
}

fun getBoolean(key: String): Boolean {
    return get(key, false) as Boolean
}


private fun get(key: String, defValue: Any): Any? {
    val type = defValue.javaClass.simpleName
    //defValue为为默认值，如果当前获取不到数据就返回它
    return when (type) {
        "Integer" -> sharedPreferences?.getInt(key, defValue as Int)
        "Boolean" -> sharedPreferences?.getBoolean(key, defValue as Boolean)
        "String" -> sharedPreferences?.getString(key, defValue as String)
        "Float" -> sharedPreferences?.getFloat(key, defValue as Float)
        "Long" -> sharedPreferences?.getLong(key, defValue as Long)
        else -> null
    }
}



