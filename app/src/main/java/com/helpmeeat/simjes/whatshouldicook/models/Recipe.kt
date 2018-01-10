package com.helpmeeat.simjes.whatshouldicook.models

class RecipeResponse(
		val recipes: List<Recipe>
)

data class Recipe(
		val vegetarian: Boolean,
		val vegan: Boolean,
		val glutenFree: Boolean,
		val dairyFree: Boolean,
		val veryHealthy: Boolean,
		val cheap: Boolean,
		val veryPopular: Boolean,
		val sustainable: Boolean,
		val weightWatcherSmartPoints: Int,
		val gaps: String,
		val lowFodmap: Boolean,
		val ketogenic: Boolean,
		val whole30: Boolean,
		val servings: Int,
		val preparationMinutes: Int,
		val cookingMinutes: Int,
		val sourceUrl: String,
		val spoonacularSourceUrl: String,
		val aggregateLikes: Int,
		val spoonacularScore: Int,
		val healthScore: Int,
		val creditText: String,
		val sourceName: String,
		val pricePerServing: Double,
		val extendedIngredients: List<ExtendedIngredient>,
		val id: Int,
		val title: String,
		val readyInMinutes: Int,
		val image: String,
		val imageType: String,
		val cuisines: List<Any>,
		val dishTypes: List<String>,
		val diets: List<String>,
		val occasions: List<Any>,
		val winePairing: WinePairing,
		val instructions: String,
		val analyzedInstructions: List<AnalyzedInstruction>
)

data class AnalyzedInstruction(
		val name: String,
		val steps: List<Step>
)

data class Step(
		val number: Int,
		val step: String,
        val ingredients: List<Ingredient>,
		val equipment: List<Equipment>,
		val length: Length
)

data class Ingredient(
		val id: Int,
		val name: String,
		val image: String
)

data class Length(
		val number: Int,
		val unit: String
)

data class Equipment(
		val id: Int,
		val name: String,
		val image: String
)

data class ExtendedIngredient(
		val id: Int,
		val aisle: String,
		val image: String,
		val consistency: String,
		val name: String,
		val amount: Double,
		val unit: String,
		val unitShort: String,
		val unitLong: String,
		val originalString: String,
		val metaInformation: List<Any>
)

data class WinePairing(
		val pairedWines: List<String>,
		val pairingText: String,
        val productMatches: List<ProductMatche>
)

data class ProductMatche(
		val id: Int,
		val title: String,
		val description: String,
        val price: String,
		val imageUrl: String,
		val averageRating: Double,
		val ratingCount: Int,
		val score: Double,
		val link: String
)