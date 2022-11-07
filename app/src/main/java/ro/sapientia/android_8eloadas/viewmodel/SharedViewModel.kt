package ro.sapientia.android_8eloadas.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ro.sapientia.android_8eloadas.model.Item
import ro.sapientia.android_8eloadas.util.Utils

class SharedViewModel : ViewModel() {
    val list = Utils().generateDummyList(100)
    var position = 0

}