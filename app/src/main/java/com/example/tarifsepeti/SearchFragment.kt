package com.example.tarifsepeti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tarifsepeti.databinding.FragmentSearchBinding

class SearchFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil. inflate<FragmentSearchBinding>(inflater, R.layout.fragment_search, container, false )

        binding.searchButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_searchFragment_to_recipesFragment)
        }


        val b1 = requireView().findViewById<CheckBox>(R.id.b1)
        val b2 = requireView().findViewById<CheckBox>(R.id.b2)
        val b3 = requireView().findViewById<CheckBox>(R.id.b3)
        val b4 = requireView().findViewById<CheckBox>(R.id.b4)
        val b5 = requireView().findViewById<CheckBox>(R.id.b5)
        val b6 = requireView().findViewById<CheckBox>(R.id.b6)
        val b7 = requireView().findViewById<CheckBox>(R.id.b7)
        val b8 = requireView().findViewById<CheckBox>(R.id.b8)
        val b9 = requireView().findViewById<CheckBox>(R.id.b9)
        val b10 = requireView().findViewById<CheckBox>(R.id.b10)
        val b11 = requireView().findViewById<CheckBox>(R.id.b11)
        val b12 = requireView().findViewById<CheckBox>(R.id.b12)
        val b13 = requireView().findViewById<CheckBox>(R.id.b13)
        val b14 = requireView().findViewById<CheckBox>(R.id.b14)
        val b15 = requireView().findViewById<CheckBox>(R.id.b15)
        val b16 = requireView().findViewById<CheckBox>(R.id.b16)
        val b17 = requireView().findViewById<CheckBox>(R.id.b17)
        val b18 = requireView().findViewById<CheckBox>(R.id.b18)
        val b19 = requireView().findViewById<CheckBox>(R.id.b19)
        val b20 = requireView().findViewById<CheckBox>(R.id.b20)
        val b21 = requireView().findViewById<CheckBox>(R.id.b21)
        val b22 = requireView().findViewById<CheckBox>(R.id.b22)
        val b23 = requireView().findViewById<CheckBox>(R.id.b23)
        val b24 = requireView().findViewById<CheckBox>(R.id.b24)




        return binding.root
    }
}