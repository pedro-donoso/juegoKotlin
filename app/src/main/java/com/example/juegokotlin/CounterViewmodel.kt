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
}