package at.ollmann.philipp.recipeapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("complexSearch?apiKey=6893bf1fd60b4ec4884e40ebec146373&diet=vegetarian&addRecipeNutrition=true")
    fun getData() : Call<Recipes>
}