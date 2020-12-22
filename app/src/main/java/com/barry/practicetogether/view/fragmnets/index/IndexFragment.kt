package com.barry.practicetogether.view.fragmnets.index

import JClickListener
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.BannerBean
import com.barry.practicetogether.model.bean.IndexBean
import com.barry.practicetogether.presenter.index.IndexPresenter
import com.barry.practicetogether.utlis.PTGlide
import com.barry.practicetogether.view.activitys.index.MyTaskActivity
import com.barry.practicetogether.view.activitys.index.TeachClassActivity
import com.barry.practicetogether.view.adapter.IndexAdapter
import com.barry.practicetogether.view.base.BaseFragment
import com.barry.practicetogether.view.iview.index.IIndexView
import kotlinx.android.synthetic.main.fragment_index.*


class IndexFragment : BaseFragment<IIndexView, IndexPresenter>(), IIndexView {

    companion object {
        val instance: IndexFragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            IndexFragment()
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_index
    }

    lateinit var indexAdapter: IndexAdapter
    override fun initView(view: View, savedInstanceState: Bundle?) {
        xBanner.loadImage { _, model, view, _ ->
            model as BannerBean
            PTGlide.loadCenterCrop(mContext, view as ImageView, model.banne)
        }
        xBanner.setOnItemClickListener { _, _, _, _ ->
        }
        indexAdapter = IndexAdapter()
        rvClass.adapter = indexAdapter

        myTask.setOnClickListener(JClickListener {
            MyTaskActivity.startMyTaskActivity(mContext)
        })
        teachClass.setOnClickListener(JClickListener {
            TeachClassActivity.startTeachClassActivity(mContext)
        })
    }


    override fun initData() {
        presenter?.getClass()
        presenter?.getBanner()
    }

    override fun createPresenter(): IndexPresenter? {
        return IndexPresenter()
    }

    override fun createView(): IIndexView? {
        return this
    }

    override fun setBanner(list: List<BannerBean>) {
        xBanner.setBannerData(list)
    }

    override fun setClassShow(list: List<IndexBean>) {
        indexAdapter.setNewInstance(list as MutableList<IndexBean>)
    }
}
