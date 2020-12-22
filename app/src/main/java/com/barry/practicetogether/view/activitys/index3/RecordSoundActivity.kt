package com.barry.practicetogether.view.activitys.index3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.barry.practicetogether.R
import java.io.File


@Suppress("DEPRECATION")
class RecordSoundActivity : Activity(), View.OnClickListener {
    companion object {
        fun startRecordSoundActivity(context: Context) {
            context.startActivity(Intent(context, RecordSoundActivity::class.java))
        }
    }

    // 定义界面上的两个按钮
    var record: ImageButton? = null
    var stop: ImageButton? = null

    // 系统的音频文件
    var soundFile: File? = null
    var mRecorder: MediaRecorder? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_sound)
        // 获取程序界面中的两个按钮
        record = findViewById<View>(R.id.record) as ImageButton
        stop = findViewById<View>(R.id.stop) as ImageButton
        // 为两个按钮的单击事件绑定监听器
        record!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    public override fun onDestroy() {
        if (soundFile != null && soundFile!!.exists()) {
            // 停止录音
            mRecorder!!.stop()
            // 释放资源
            mRecorder!!.release()
            mRecorder = null
        }
        super.onDestroy()
    }

    override fun onClick(source: View) {
        when (source.id) {
            R.id.record -> {
                if (Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED
                ) {
                    Toast.makeText(
                        this, "SD卡不存在，请插入SD卡！",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                try {

                    // 创建保存录音的音频文件
                    soundFile = File(
                        Environment
                            .getExternalStorageDirectory().canonicalFile
                            .toString() + "/sound.amr"
                    )
                    Toast.makeText(this, "开始录音" + soundFile, Toast.LENGTH_SHORT).show()

                    mRecorder = MediaRecorder()
                    // 设置录音的声音来源
                    mRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
                    // 设置录制的声音的输出格式（必须在设置声音编码格式之前设置）
                    mRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB)
                    // 设置声音编码的格式
                    mRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                    mRecorder!!.setOutputFile(soundFile!!.absolutePath)
                    mRecorder!!.prepare()
                    // 开始录音
                    mRecorder!!.start() //①
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            R.id.stop -> {
                Toast.makeText(this, "停止录音", Toast.LENGTH_SHORT).show()
                if (soundFile != null && soundFile!!.exists()) {
                    Toast.makeText(this, "停止录音", Toast.LENGTH_SHORT).show()
                    // 停止录音
                    mRecorder!!.stop() //②
                    // 释放资源
                    mRecorder!!.release() //③
                    mRecorder = null
                }
            }
        }
    }
}