package com.barry.practicetogether.view.iview.index

import com.barry.practicetogether.model.bean.MyTask
import com.barry.practicetogether.view.iview.IBaseView

/**
 *Created by Barry
 **/
interface IMyTaskView : IBaseView {
    fun setTask(list: List<MyTask>)
}