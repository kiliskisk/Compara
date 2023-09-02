package com.curso.android.app.practica.compara.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.compara.model.Compara

class MainViewModel : ViewModel() {

    val texto : LiveData<Compara>get() = _texto

    private var _texto = MutableLiveData<Compara>(Compara("", "",  "ComparaStr 1.0"))

   fun asignar(text1: String, text2: String) {

        comparar(text1 ,text2)
    }

    private fun comparar(t1: String, t2: String)  {

        if (t1.equals(t2)) {
            _texto.value = Compara(t1,t2, " es igual a " )
        } else {
            _texto.value = Compara(t1,t2, " es diferente de " )
        }


     }
}




