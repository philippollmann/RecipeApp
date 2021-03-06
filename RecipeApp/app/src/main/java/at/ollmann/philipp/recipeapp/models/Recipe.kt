package at.ollmann.philipp.recipeapp.models

import java.io.Serializable

data class Recipe(
    val aggregateLikes: Int,
    val analyzedInstructions: List<AnalyzedInstruction>?,
    val cheap: Boolean,
    val cookingMinutes: Int,
    val creditsText: String,
    val cuisines: List<String>,
    val dairyFree: Boolean,
    val diets: List<String>,
    val dishTypes: List<String>,
    val extendedIngredients: List<ExtendedIngredient>,
    val gaps: String,
    val glutenFree: Boolean,
    val healthScore: Double,
    val id: Int,
    val image: String,
    val imageType: String,
    val license: String,
    val likes: Int,
    val lowFodmap: Boolean,
    val missedIngredientCount: Int,
    //val missedIngredients: List<MissedIngredient>,
    val occasions: List<Any>,
    val preparationMinutes: Int,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String,
    val summary: String,
    val sustainable: Boolean,
    val title: String,
    val unusedIngredients: List<Any>,
    val usedIngredientCount: Int,
    val usedIngredients: List<Any>,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: Int
) : Serializable