package com.barry.practicetogether.view.activitys

import JClickListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.barry.practicetogether.R
import com.barry.practicetogether.model.bean.Index1ClassBean
import com.barry.practicetogether.model.bean.SelectClass
import com.barry.practicetogether.utlis.isPhone
import com.barry.practicetogether.view.adapter.RegisterSelectAdapter
import com.barry.practicetogether.view.base.BaseUnModelActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.include_toolbar.*


class RegisterActivity : BaseUnModelActivity() {
    companion object {
        fun startRegisterActivity(context: Context) {
            context.startActivity(Intent(context, RegisterActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    lateinit var registerSelectAdapter: RegisterSelectAdapter
    override fun getTitleText(): String {
        return "注册"
    }

    private var classlist: MutableList<SelectClass> = ArrayList()
    override fun initViews() {
        initToolbar(commToolBar)
        for (index in 0..1) {
            var bannerBean = SelectClass()
            bannerBean.name = "吉他$index"
            classlist.add(bannerBean)
        }

        registerSelectAdapter = RegisterSelectAdapter()
        rv.adapter = registerSelectAdapter
        registerSelectAdapter.setList(classlist)
        val list: ArrayList<String> = arrayListOf()
        list.add("选择机构")
        list.add("机构1")
        list.add("机构2")
        list.add("机构3")
        list.add("机构4")
        val adapters = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = adapters

        sp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View,
                position: Int, id: Long
            ) {
                showToast("${list[position]}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        getCode.setOnClickListener(JClickListener {
            showToast("验证码已发送指定${"13993365940"}请注意查收")
        })
    }

    override fun initData() {
    }
}