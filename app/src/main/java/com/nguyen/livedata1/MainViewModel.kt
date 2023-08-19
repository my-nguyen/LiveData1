package com.nguyen.livedata1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModel(start: Int) : ViewModel() {
    private var _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init {
        _count.value = start
    }

    fun updateCount(){
        _count.value = (_count.value)?.plus(1)
    }
}

class MainViewModelFactory(private val count: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(count) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}