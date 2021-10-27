package at.ollmann.philipp.recipeapp

data class IngredientX(
    val amount: Double,
    val id: Int,
    val name: String,
    val nutrients: List<Nutrient>,
    val unit: String
)