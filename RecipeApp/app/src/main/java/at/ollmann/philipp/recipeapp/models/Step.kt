package at.ollmann.philipp.recipeapp.models

import java.io.Serializable

data class Step(
    // val equipment: List<Equipment>,
    // val ingredients: List<Ingredient>,
    //val length: Length?,
    val number: Int?,
    val step: String?
) : Serializable