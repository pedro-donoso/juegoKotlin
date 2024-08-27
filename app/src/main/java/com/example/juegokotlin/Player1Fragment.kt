package com.example.juegokotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.juegokotlin.databinding.FragmentPlayer1Binding

class Player1Fragment : Fragment() {

    private var _binding: FragmentPlayer1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: CounterViewModel by activityViewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     _binding = FragmentPlayer1Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            counterText.text = viewModel.counter1.value.toString()
            clickButton.setOnClickListener {
                viewModel.incrementCounter1()
                viewModel.decrementCounter2()
            }
        }

        viewModel.counter1.observe(viewLifecycleOwner) {
            binding.counterText.text = it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}