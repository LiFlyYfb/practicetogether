package com.barry.practicetogether.view

import android.content.Context
import android.content.Intent
import androidx.viewpager2.widget.ViewPager2
import com.barry.practicetogether.view.adapter.PagerAdapter
import com.barry.practicetogether.view.fragmnets.index1.Index1Fragment
import com.barry.practicetogether.view.fragmnets.index.IndexFragment
import com.barry.practicetogether.view.fragmnets.index2.Index2Fragment
import com.barry.practicetogether.R
import com.barry.practicetogether.view.base.BaseUnModelActivity
import com.barry.practicetogether.view.fragmnets.index3.Index3Fragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseUnModelActivity() {
    companion object {
        fun startMainActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
        val fragments = arrayListOf(
            IndexFragment.instance,
            Index1Fragment.instance,
            Index2Fragment.instance,
            Index3Fragment.instance
        )
        mainViewPager.isUserInputEnabled = false
        mainViewPager.adapter = PagerAdapter(this, fragments)
        mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                navigationView.menu.getItem(position).isChecked = true
            }
        })
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.index -> mainViewPager.setCurrentItem(0, true)
                R.id.index1 -> mainViewPager.setCurrentItem(1, true)
                R.id.index2 -> mainViewPager.setCurrentItem(2, true)
                R.id.index3 -> mainViewPager.setCurrentItem(3, true)
            }
            true
        }
    }

    override fun initData() {
    }


}