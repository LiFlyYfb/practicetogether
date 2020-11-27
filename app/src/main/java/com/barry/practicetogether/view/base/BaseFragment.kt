package com.barry.practicetogether.view.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.dialog.LoadingDialog
import com.barry.practicetogether.view.iview.IBaseView


abstract class BaseFragment<V : IBaseView, P : BasePresenter<V>> : Fragment(), IBaseView {

    private var view: V? = null
    var presenter: P? = null
    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = this.activity!!
        initView(view, savedInstanceState)
        initMVP()
        initData()
    }

    abstract fun getLayout(): Int

    abstract fun initView(view: View, savedInstanceState: Bundle?)

    private fun initMVP() {
        if (view == null) {
            view = createView()
        }

        if (presenter == null) {
            presenter = createPresenter()
        }

        presenter?.bind(view)
    }

    abstract fun createPresenter(): P?

    abstract fun createView(): V?

    abstract fun initData()

    override val filePath: String
        get() = mContext.filesDir.absolutePath


    override fun onError(code: Int, msg: String) {
        if (code == 1002) {
            return
        }
        loadingDialog?.dismiss()
        showToast(msg)
    }

    fun showToast(msg: String) {
        (activity as BaseActivity<*, *>).showToast(msg)
    }

    private var loadingDialog: LoadingDialog? = null
    override fun startLoading() {
        Log.d("111111", "BaseFragment startLoading: ")

//        if (loadingDialog == null) {
        loadingDialog = LoadingDialog(mContext)
//        }
        if (activity == null || activity!!.isDestroyed) {
            return
        }
        loadingDialog?.show()
    }

    override fun endLoading() {
        loadingDialog?.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
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