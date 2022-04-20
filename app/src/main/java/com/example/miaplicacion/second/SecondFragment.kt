package com.example.miaplicacion.second

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.miaplicacion.R
import com.example.miaplicacion.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }
/*
    private lateinit var viewModel: SecondViewModel
*/
private val viewModel: SecondViewModel by lazy {
    ViewModelProvider(this).get(SecondViewModel::class.java)
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SecondFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.second_fragment, container, false)

        //val secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel

        binding.secondViewModel = viewModel

        binding.lifecycleOwner = this


        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}