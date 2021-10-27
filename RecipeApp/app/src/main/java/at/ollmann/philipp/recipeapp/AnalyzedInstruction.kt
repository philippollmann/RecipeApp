package at.ollmann.philipp.recipeapp

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)