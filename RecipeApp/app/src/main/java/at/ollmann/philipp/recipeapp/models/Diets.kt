package at.ollmann.philipp.recipeapp.models

enum class Diets(val key: String) {
    VEGETARIAN("vegetarian"),
    VEGAN("vegan"),
    GLUTEN_FREE("gluten free"),
    KETOGENIC("ketogenic"),
    LACTO_VEGETARIAN("lacto vegetarian"),
    OVO_VEGETARIAN("ovo vegetarian"),
    PESCETARIAN("pescetarian"),
    PALEO("paleo"),
    PRIMAL("primal"),
    Whole30("whole30")
}