package com.example.recipeappviewmodel

import androidx.lifecycle.LiveData

class RecipeRepository( private val recipeDao : RecipeDao) {
    val getRecipe : LiveData<List<RecipeDetails>> = recipeDao.getRecipe()

    suspend fun addRecipe(recipe : RecipeDetails){
        recipeDao.insertRecipe(
                RecipeDetails(recipe.id,
                        recipe.title,
                        recipe.author,
                        recipe.ingredients,
                        recipe.instructions)
        )
    }
}