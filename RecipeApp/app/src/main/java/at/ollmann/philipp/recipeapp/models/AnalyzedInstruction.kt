package at.ollmann.philipp.recipeapp.models

import java.io.Serializable

data class AnalyzedInstruction(
    val name: String?,
    val steps: List<Step>?
) : Serializable