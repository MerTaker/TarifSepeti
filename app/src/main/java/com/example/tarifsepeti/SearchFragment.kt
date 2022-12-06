package com.example.tarifsepeti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tarifsepeti.databinding.FragmentSearchBinding

class SearchFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil. inflate<FragmentSearchBinding>(inflater, R.layout.fragment_search, container, false )

        binding.searchBackButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_searchFragment_to_mainFragment)
        }

        binding.searchButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_searchFragment_to_recipesFragment)
        }

        return binding.root
    }
}