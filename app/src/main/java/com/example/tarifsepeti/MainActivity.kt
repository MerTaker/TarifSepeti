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
//        val selectedIngredients = ArrayList<String>()
//        selectedIngredients.add("Tomato")
//        selectedIngredients.add("Rice")
//        selectedIngredients.add("Butter")
//        selectedIngredients.add("Salt")
//        selectedIngredients.add("Water")
//        selectedIngredients.add("Lemon juice")
//        a.getAvailableRecipies(selectedIngredients)
//        for (recipe in a.availableRecipes) {
//            println(recipe.name)
//        }
    }
}

object RecipeObject {

     var recipeList : ArrayList<Recipe> = ArrayList()
     var jsonData : String = String()
     var selectedIngredients : ArrayList<String> = ArrayList()
     var availableRecipes : ArrayList<Recipe> = ArrayList()

    fun init(theData : String):RecipeObject {
        this.jsonData = theData
        val recipes = Gson().fromJson<RecipeList>(theData, RecipeList::class.java)
        this.recipeList = recipes.recipeList as ArrayList<Recipe>
        //fill available recipes
        //getAvailableRecipies()
        return this
    }

    fun getAvailableRecipies() {
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

data class Recipe(val name : String, val description : String, val time : String, val serves : String, val imgSrc : String, val ingredients : Array<String>, val detailedIngredients : Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (name != other.name) return false
        if (description != other.description) return false
        if (time != other.time) return false
        if (serves != other.serves) return false
        if (imgSrc != other.imgSrc) return false
        if (!ingredients.contentEquals(other.ingredients)) return false
        if (!detailedIngredients.contentEquals(other.detailedIngredients)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + serves.hashCode()
        result = 31 * result + imgSrc.hashCode()
        result = 31 * result + ingredients.contentHashCode()
        result = 31 * result + detailedIngredients.contentHashCode()
        return result
    }
}

data class RecipeList(val recipeList: List<Recipe> )