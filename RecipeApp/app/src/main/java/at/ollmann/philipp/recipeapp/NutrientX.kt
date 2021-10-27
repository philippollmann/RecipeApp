package at.ollmann.philipp.recipeapp

data class NutrientX(
    val amount: Double,
    val name: String,
    val percentOfDailyNeeds: Double,
    val title: String,
    val unit: String
)