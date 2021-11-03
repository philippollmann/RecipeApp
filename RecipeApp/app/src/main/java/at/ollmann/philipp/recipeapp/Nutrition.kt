package at.ollmann.philipp.recipeapp

import java.io.Serializable

data class Nutrition(
    //val caloricBreakdown: CaloricBreakdown,
    //val flavonoids: List<Flavonoid>,
    //val ingredients: List<IngredientX>,
    val nutrients: List<NutrientX>,
    //val properties: List<Property>,
    //val weightPerServing: WeightPerServing
) : Serializable