package at.ollmann.philipp.recipeapp

import at.ollmann.philipp.recipeapp.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("complexSearch?apiKey=6893bf1fd60b4ec4884e40ebec146373")
    fun getData(
        @Query("diet") diet: String? = null,
        @Query("query") query: String? = null,
        @Query("addRecipeInformation") addNutrition: Boolean = true,
        @Query("fillIngredients") fillIngredients: Boolean = true,
        @Query("number") number: Int = 10,
    ) : Call<Recipes>
}