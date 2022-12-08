package com.example.tarifsepeti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tarifsepeti.databinding.FragmentRecipesBinding

class RecipesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recipeObject = RecipeObject
        println(recipeObject.selectedIngredients)

        val binding = DataBindingUtil. inflate<FragmentRecipesBinding>(inflater, R.layout.fragment_recipes, container, false)

        binding.recipesBackButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_recipesFragment_to_searchFragment)
        }

        binding.recipesNextButton.setOnClickListener() { view :View ->
            view.findNavController().navigate (R.id.action_recipesFragment_to_detailedFragment)
        }

        return binding.root

    }
}