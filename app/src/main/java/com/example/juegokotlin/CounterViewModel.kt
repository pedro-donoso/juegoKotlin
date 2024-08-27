package com.example.juegokotlin

//importaciones
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//clase CounterViewModel que hereda de ViewModel
class CounterViewModel: ViewModel() {

    //variables para almacenar los contadores y el ganador
    private val _counter1 = MutableLiveData(10)
    //propiedad para observar los cambios en el contador 1
    val counter1 = _counter1

    private val _counter2 = MutableLiveData(10)
    //propiedad para observar los cambios en el contador 2
    val counter2 = _counter2

    //variable para almacenar el ganador
    private val _winner = MutableLiveData<String?>(null)
    val winner = _winner

    //Funcion para comprobar el ganador
    private fun checkWinner(){
        if(_counter1.value == 20){
            _winner.value = "Player 1"
        }else if(_counter2.value == 20){
            _winner.value = "Player 2"
        }
    }

    //funciones para incrementar y decrementar los contadores
    fun incrementCounter1(){
        _counter1.value = (_counter1.value ?: 10) + 1
        checkWinner()
    }

    fun incrementCounter2(){
        _counter2.value = (_counter2.value ?: 10) + 1
        checkWinner()
    }

    fun decrementCounter1(){
        _counter1.value = (_counter1.value ?: 10) - 1
        checkWinner()
    }

    fun decrementCounter2(){
        _counter2.value = (_counter2.value ?: 10) - 1
        checkWinner()
    }

    //funcion para reiniciar los contadores y el ganador
    fun resetCounters(){
        _counter1.value = 10
        _counter2.value = 10
        _winner.value = null
    }
}