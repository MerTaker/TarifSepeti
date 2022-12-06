package com.example.tarifsepeti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tarifsepeti.databinding.FragmentMainBinding
import com.example.tarifsepeti.databinding.FragmentSearchBinding

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil. inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false )

        binding.findRecipeButton.setOnClickListener() { view :View->
            view.findNavController().navigate (R.id.action_mainFragment_to_searchFragment)
        }

        return binding.root
    }

}