package com.geekbrains.tests.presenter

import android.view.View
import com.geekbrains.tests.view.details.ViewDetailsContract

internal interface PresenterContract<View> {
    fun onAttach(view:View)
    fun onDetach()
}
