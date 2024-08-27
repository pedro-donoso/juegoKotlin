package com.example.juegokotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewmodel: ViewModel() {
    private val _counter1 = MutableLiveData(10)
    val counter1 = _counter1

    private val _counter2 = MutableLiveData(10)
    val counter2 = _counter2

    private val _winner = MutableLiveData<String>(null)
    val winner = _winner

    private fun checkWinner(){
        if(_counter1.value == 20){
            _winner.value = "Player 1"
        }else if(_counter2.value == 20){
            _winner.value = "Player 2"
        }
    }

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

}