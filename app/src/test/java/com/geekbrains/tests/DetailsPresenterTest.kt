package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.presenter.search.SearchPresenter
import com.geekbrains.tests.repository.GitHubRepository
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

   // @Mock
   // private var count: Int = 0

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //Создаем Презентер
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun setCounter_Test(){
        val countTest = 1
        //Запускаем код, функционал которого хотим протестировать
        presenter.setCounter(countTest)
        //Убеждаемся, что все работает
        Mockito.verify(viewContract, Mockito.times(1)).setCount(1)
    }

    @Test
    fun onIncrement_Test(){
        //Запускаем код, функционал которого хотим протестировать
        presenter.onIncrement()
        presenter.onIncrement()
        //Убеждаемся, что все работает
        Mockito.verify(viewContract,Mockito.times(1)).setCount(2)
    }

    @Test
    fun onDecrement_Test(){
        presenter.onDecrement()
        Mockito.verify(viewContract,Mockito.times(1)).setCount(-1)
    }

    @Test
    fun onDetach_Test(){
        presenter.onDetach()
        presenter.setCounter(1)
        presenter.setCounter(1)
        presenter.setCounter(1)
        presenter.setCounter(1)
        Mockito.verify(viewContract,Mockito.times(0)).setCount(anyInt())
    }

}