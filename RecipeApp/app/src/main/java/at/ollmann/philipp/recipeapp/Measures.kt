package at.ollmann.philipp.recipeapp

import java.io.Serializable

data class Measures(
    val metric: Metric,
    val us: Us
) : Serializable