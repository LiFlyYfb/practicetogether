package com.barry.practicetogether.utlis

import android.content.ComponentName
import android.content.Context
import android.content.Intent


fun share2App(context: Context, url: String, cls: String = "com.tencent.mm.ui.tools.ShareImgUI") {
    val cop = ComponentName("com.tencent.mm", cls)
    val intent = Intent()
    intent.component = cop
    intent.action = Intent.ACTION_SEND
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.putExtra(Intent.EXTRA_STREAM, getUri(context, url))
    intent.type = "image/*"
    context.startActivity(Intent.createChooser(intent, "Share"))
}
