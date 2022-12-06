package com.example.tarifsepeti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tarifsepeti.databinding.FragmentDetailedBinding

class DetailedFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil. inflate<FragmentDetailedBinding>(inflater, R.layout.fragment_detailed, container, false)

        binding.detailedBackButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_detailedFragment_to_recipesFragment)
        }

        return binding.root
    }
}