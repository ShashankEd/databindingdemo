package com.example.incrementnumberdatabidingandviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncrementViewModel(): ViewModel() {

    private var numberValue = MutableLiveData<Int>()

    //we'll observe on this currentNumberValue live data which holds the numberValue MutableLiveData object
    val currentNumberValue: LiveData<Int>
    get() = numberValue

    init {
        numberValue.value = 0
    }
    fun increment() {
        //Kotlin syntax to add with null check
        numberValue.value = numberValue.value?.plus(1)
    }

}