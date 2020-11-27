package com.barry.practicetogether.view.fragmnets.index1


class ClassFragment : BaseClassFragment() {
    companion object {
        val instance: ClassFragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ClassFragment()
        }
    }

    override fun type(): String {
        return "0"
    }
}