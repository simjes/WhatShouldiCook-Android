package com.helpmeeat.simjes.whatshouldicook.repositories

import co.metalab.asyncawait.async
import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.services.RecipeApi
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository {
    @Inject lateinit var recipeApi: RecipeApi

    init {
       DaggerAppComponent.builder().build().injectRecipeService(this)
    }

    fun GetNextRecipes(): List<Recipe> {
        val recipes = runBlocking {
            async(CommonPool) {
                val response = recipeApi.getRandomRecipes().execute()
                return@async response.body()
            }.await()
        }
        return recipes!!
    }
}