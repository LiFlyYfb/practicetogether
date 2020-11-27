package com.barry.practicetogether.view.base

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.barry.practicetogether.R
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.dialog.LoadingDialog
import com.barry.practicetogether.view.iview.IBaseView

abstract class BaseActivity<V : IBaseView, P : BasePresenter<V>> : AppCompatActivity(), IBaseView {

    private var view: V? = null
    var presenter: P? = null
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mContext = this
        initViews()
        initMvp()
        initData()
    }

    abstract fun getLayout(): Int
    abstract fun initViews()

    private fun initMvp() {
        if (view == null) {
            view = createView()
        }

        if (presenter == null) {
            presenter = createPresenter()
        }

        presenter?.bind(view)
    }

    abstract fun initData()

    abstract fun createPresenter(): P?

    abstract fun createView(): V?


    fun initToolbar(toolbar: Toolbar) {
        toolbar.setNavigationIcon(getBackIcon())
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        val title: TextView = toolbar.findViewById(R.id.commTitle)
        title.text = getTitleText()
    }

    open fun getBackIcon(): Int {
        return R.drawable.ic_launcher_background
    }


    open fun getTitleText(): String {
        return ""
    }

    fun showToast(msg: String) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onError(code: Int, msg: String) {
        if (code == 1002) {

            return
        }
        loadingDialog?.dismiss()
        showToast(msg)
    }

    override val filePath: String
        get() {
            return mContext.filesDir.absolutePath
        }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unBind()
        loadingDialog?.dismiss()
    }

    private var loadingDialog: LoadingDialog? = null
    override fun startLoading() {
//        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(mContext)
//        }
        loadingDialog?.show()
    }

    override fun endLoading() {
        loadingDialog?.dismiss()
    }

    fun dimiss(){
        loadingDialog?.dismiss()
    }

    override fun onResume() {
        super.onResume()
        // 选用MANUAL页面采集模式
    }

    @Override
    override fun onPause() {
        super.onPause();
    }
}