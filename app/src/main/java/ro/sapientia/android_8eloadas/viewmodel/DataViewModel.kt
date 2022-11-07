package ro.sapientia.android_8eloadas.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {
    private lateinit var timer:CountDownTimer
    val _seconds = MutableLiveData<Int>()

    fun startTimer(){
        timer = object:CountDownTimer(100000, 1000){
            override fun onTick(p0: Long) {
                val timeLeft = p0/1000;
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
            }

        }
        timer.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}