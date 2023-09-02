package com.curso.android.app.practica.compara

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.compara.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun MainViewModel_Inicializa_Variable_Vacio() = runTest{
        val value = viewModel.texto.value?.txt1
        Assert.assertEquals("", value)
    }

    @Test
    fun MainViewModel_btnComparar_Diferentes() = runTest{
        launch {
            viewModel.asignar("Prueba","prueba")
        }

        advanceUntilIdle()

        val value = viewModel.texto.value?.resultado
        Assert.assertEquals(" es diferente de ", value)

    }

    @Test
    fun MainViewModel_btnComparar_Iguales() = runTest{
        launch {

            viewModel.asignar("Prueba","Prueba")
        }
        advanceUntilIdle()

        val value = viewModel.texto.value?.resultado
        Assert.assertEquals(" es igual a ", value)
    }
}