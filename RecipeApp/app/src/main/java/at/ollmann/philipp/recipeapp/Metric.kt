package at.ollmann.philipp.recipeapp

import java.io.Serializable

data class Metric(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
) : Serializable