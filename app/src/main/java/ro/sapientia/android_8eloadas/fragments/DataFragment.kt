package ro.sapientia.android_8eloadas.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ro.sapientia.android_8eloadas.R
import ro.sapientia.android_8eloadas.viewmodel.DataViewModel


class DataFragment : Fragment() {

    val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = view.findViewById(R.id.textViewSeconds)
        val button: Button = view.findViewById(R.id.buttonStop)

        viewModel.startTimer()
        viewModel._seconds.observe(this.viewLifecycleOwner, Observer{
            val seconds = it.toString()
            textView.setText(seconds)
        })

        button.setOnClickListener{
            viewModel.stopTimer()
        }
    }
}