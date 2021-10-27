package at.ollmann.philipp.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RecipeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val recipe: Recipe? = intent.getSerializableExtra("recipe") as Recipe?
        Toast.makeText(applicationContext, recipe!!.title,Toast.LENGTH_SHORT).show()

    }
}