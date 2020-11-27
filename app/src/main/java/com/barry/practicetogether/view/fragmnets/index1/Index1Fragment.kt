package com.barry.practicetogether.view.fragmnets.index1

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.BannerBean
import com.barry.practicetogether.model.bean.IndexBean
import com.barry.practicetogether.presenter.index1.Index1Presenter
import com.barry.practicetogether.view.MainActivity
import com.barry.practicetogether.view.adapter.PagerAdapter
import com.barry.practicetogether.view.base.BaseFragment
import com.barry.practicetogether.view.iview.index1.IIndexView1
import kotlinx.android.synthetic.main.fragment_index1.*
import kotlinx.android.synthetic.main.include_toolbar.*

class Index1Fragment : BaseFragment<IIndexView1, Index1Presenter>(), IIndexView1 {
    companion object {
        val instance: Index1Fragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Index1Fragment()
        }
    }


    override fun getLayout(): Int {
        return R.layout.fragment_index1
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        commTitle.text = "约课"
        commNext.text = "去约课"
        val fragments = arrayListOf(ClassFragment.instance, FinishClassFragment.instance)
        var mainActivity = activity as MainActivity
        vpClass.adapter = PagerAdapter(mainActivity, fragments)
        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio0 -> {
                    vpClass.currentItem = 0
                }
                R.id.radio1 -> {
                    vpClass.currentItem = 1
                }
            }
        }

        vpClass.registerOnPageChangeCallback(pageChangeCallback)

    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when (position) {
                0 -> radio0.isChecked = true
                1 -> radio1.isChecked = true
            }
        }
    }


    override fun initData() {
    }

    override fun createPresenter(): Index1Presenter? {
        return Index1Presenter()
    }

    override fun createView(): IIndexView1? {
        return this
    }

    override fun setBanner(list: List<BannerBean>) {
    }

    override fun setClassShow(list: List<IndexBean>) {
    }

}