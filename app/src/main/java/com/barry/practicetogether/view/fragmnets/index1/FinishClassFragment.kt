package com.barry.practicetogether.view.fragmnets.index1


class FinishClassFragment : BaseClassFragment() {
    companion object {
        val instance: FinishClassFragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            FinishClassFragment()
        }
    }

    override fun type(): String {
        return "1"
    }

}