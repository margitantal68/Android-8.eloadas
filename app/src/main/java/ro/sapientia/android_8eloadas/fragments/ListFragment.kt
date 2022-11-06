package ro.sapientia.android_8eloadas.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ro.sapientia.android_8eloadas.R
import ro.sapientia.android_8eloadas.adapter.DataAdapter
import ro.sapientia.android_8eloadas.adapter.OnItemClickListener
import ro.sapientia.android_8eloadas.model.Item
import ro.sapientia.android_8eloadas.util.Utils
import ro.sapientia.android_8eloadas.viewmodel.SharedViewModel


class ListFragment : Fragment(),
    OnItemClickListener { // List Item event handling

//    val sharedViewModel: SharedViewModel by viewModels()
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var list: List<Item>
    lateinit var adapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //list = Utils().generateDummyList(100)
        list = sharedViewModel.list
        val recycler_view: RecyclerView = view.findViewById(R.id.recycler_view)
        // 1. No event handling
        // recycler_view.adapter = DataAdapter(list)
        // 2. Event handling - pass fragment (this) to data adapter
        adapter = DataAdapter(list, this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        // 1. valtozat
        sharedViewModel.position = position
        // 2. valtozat
        // sharedViewModel.position.value = position

        Log.d("XXX", "" + position)
        Log.d("XXX", "ListFragment - HashCode ${sharedViewModel.hashCode()}")

        findNavController().navigate(R.id.action_listFragment_to_detailFragment)

    }
}