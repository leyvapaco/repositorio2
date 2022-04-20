package com.example.miaplicacion.first

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.miaplicacion.R
import com.example.miaplicacion.database.User
import com.example.miaplicacion.database.UserDatabase
import com.example.miaplicacion.database.UserDatabaseDao
import com.example.miaplicacion.databinding.FirstFragmentBinding


class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }
/*
    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FirstFragmentBinding
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FirstFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.first_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao

        val viewModelFactory = FirstViewModelFactory(dataSource, application)

        val firstViewModel =
        ViewModelProvider(
            this, viewModelFactory).get(FirstViewModel::class.java)

        binding.firstViewModel = firstViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}