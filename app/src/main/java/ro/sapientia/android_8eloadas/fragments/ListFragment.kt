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
    OnItemClickListener {

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

        list = sharedViewModel.list
        val recycler_view: RecyclerView = view.findViewById(R.id.recycler_view)
        adapter = DataAdapter(list, this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.setHasFixedSize(true)

    }

    // List Item event handling - OnItemClickListener
    override fun onItemClick(position: Int) {
        sharedViewModel.position = position
        Log.d("XXX", "ListFragment - HashCode ${sharedViewModel.hashCode()}")
        findNavController().navigate(R.id.action_listFragment_to_detailFragment)

    }
}