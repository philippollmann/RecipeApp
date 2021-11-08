package at.ollmann.philipp.recipeapp.models

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)