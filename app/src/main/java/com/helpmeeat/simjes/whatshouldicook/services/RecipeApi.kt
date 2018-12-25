package com.helpmeeat.simjes.whatshouldicook.services

import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import retrofit2.Call
import retrofit2.http.GET


interface RecipeApi {
    @GET("/randomRecipes")
    fun getRandomRecipes(): Call<MutableList<Recipe>>
}