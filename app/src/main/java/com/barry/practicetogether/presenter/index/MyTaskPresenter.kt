package com.barry.practicetogether.presenter.index

import com.barry.practicetogether.model.bean.MyTask
import com.barry.practicetogether.presenter.base.BasePresenter
import com.barry.practicetogether.view.iview.index.IMyTaskView

/**
 *Created by Barry
 **/
class MyTaskPresenter : BasePresenter<IMyTaskView>() {
    var myTaskList: MutableList<MyTask> = arrayListOf()
    var myLi = arrayOf("木吉他", "电子琴", "爵士鼓")
    var myl1 = arrayOf(
        "木吉他木L吉他木吉他木吉他木吉他木吉他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他他木吉他木吉吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他木吉他",
        "电子琴电子琴电子琴电子琴琴电子琴电子琴电子琴电子琴电子琴电子琴电子琴电子", "爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓爵士鼓"
    )

    fun myTaskList() {
        myTaskList.clear()
        for (index in 0..2) {
            val myTaskBean = MyTask()
            myTaskBean.name = myLi[index]
            myTaskBean.className = "课程学习$index"
            myTaskBean.time = "周二，12-1$index 王老师课程"
            myTaskBean.content = myl1[index]
            myTaskList.add(myTaskBean)
        }
        view?.setTask(myTaskList)
    }
}