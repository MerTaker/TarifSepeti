package com.example.tarifsepeti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonData = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "recipes",
                "raw", applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }
        val a = RecipeObject.init(jsonData)
        val selectedIngredients = ArrayList<String>()
        selectedIngredients.add("Tomato")
        selectedIngredients.add("Rice")
        selectedIngredients.add("Butter")
        selectedIngredients.add("Salt")
        selectedIngredients.add("Water")
        selectedIngredients.add("Lemon juice")
        a.getAvailableRecipies(selectedIngredients)
        for (recipe in a.availableRecipes) {
            println(recipe.name)
        }
    }
}

object RecipeObject {

     var recipeList : List<Recipe> = ArrayList()
     var jsonData : String = String()
     var selectedIngredients : ArrayList<String> = ArrayList()
     var availableRecipes : ArrayList<Recipe> = ArrayList()

    fun init(theData : String):RecipeObject {
        this.jsonData = theData
        val recipes = Gson().fromJson<RecipeList>(theData, RecipeList::class.java)
        this.recipeList = recipes.recipeList
        //fill available recipes
        //getAvailableRecipies()
        return this
    }

    fun getAvailableRecipies(theSelectedIngredients : ArrayList<String>) {
        this.selectedIngredients=theSelectedIngredients
        for (recipe in recipeList) {
            var key = true
            for (ingredient in recipe.ingredients) {
                if (!selectedIngredients.contains(ingredient)) {
                    key = false
                    break
                }
            }
            if (key) this.availableRecipes.add(recipe)
        }
    }
}

data class Recipe(val name : String, val description : String, val time : String, val serves : String, val imgSrc : String, val ingredients : Array<String>, val detailedIngredients : Array<String>)
data class RecipeList(val recipeList: List<Recipe> )