package com.example.tarifsepeti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tarifsepeti.databinding.ActivityRecipeDetailBinding

class RecipeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recipe_detail)
        val binding : ActivityRecipeDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_recipe_detail)
        val selectedRecipe = intent.getSerializableExtra("RECIPE") as Recipe
        binding.recipe = selectedRecipe
    }
}