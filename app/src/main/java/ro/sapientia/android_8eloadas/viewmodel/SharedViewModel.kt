package ro.sapientia.android_8eloadas.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ro.sapientia.android_8eloadas.model.Item
import ro.sapientia.android_8eloadas.util.Utils

class SharedViewModel : ViewModel() {
    // 1. valtozat
    val list = Utils().generateDummyList(100)
    var position = 0

    //2. valtozat
//    val list: MutableList<Item> = Utils().generateDummyList(100).toMutableList()
//    val position = MutableLiveData<Int>(0)

}