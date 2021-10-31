package com.example.recipeappviewmodel

import android.app.Application
import android.provider.ContactsContract
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (applicationContext : Application): AndroidViewModel(applicationContext)  {
    private val recipes: LiveData<List<RecipeDetails>>
    val applicationContext = applicationContext

    init {
        recipes = RecipeDatabase.getInstance(applicationContext).RecipeDao().getRecipe()
    }

    fun getRecipes(): LiveData<List<RecipeDetails>>{
        return recipes
    }

    fun addRecipe(r:RecipeDetails){
        CoroutineScope(Dispatchers.IO).launch {
            RecipeDatabase.getInstance(applicationContext).RecipeDao().insertRecipe(
                RecipeDetails(r.id,
                    r.title,
                    r.author,
                    r.ingredients,
                    r.instructions)
            )
            println("added")
        }
    }
/*
    fun updateRecipe(r:RecipeDetails){
        CoroutineScope(Dispatchers.IO).launch {
                val s =
                    RecipeDatabase.getInstance(applicationContext).RecipeDao()
                }
        }

    fun deleteRecipe(recipeID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val del =
           RecipeDatabase.getInstance(applicationContext).RecipeDao()
        }
    }
 */
}