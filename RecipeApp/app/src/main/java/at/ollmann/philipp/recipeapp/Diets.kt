package at.ollmann.philipp.recipeapp

enum class Diets(val key: String, index: Int) {
    VEGETARIAN("vegetarian", 0),
    VEGAN("vegan", 1),
    GLUTEN_FREE("gluten_free", 2),
    KETOGENIC("ketogenic", 3),
    LACTO_VEGETARIAN("lacto-vegetarian", 4),
    OVO_VEGETARIAN("ovo-vegetarian", 5),
    PESCETARIAN("pescetarian", 6),
    PALEO("paleo", 7),
    PRIMAL("primal", 8),
    Whole30("whole30", 9)
}