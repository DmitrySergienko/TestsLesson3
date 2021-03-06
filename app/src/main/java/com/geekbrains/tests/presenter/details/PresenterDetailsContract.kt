package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.presenter.PresenterContract

internal interface PresenterDetailsContract<View> : PresenterContract<View> {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
