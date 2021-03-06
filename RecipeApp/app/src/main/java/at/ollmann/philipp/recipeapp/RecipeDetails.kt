package at.ollmann.philipp.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.ollmann.philipp.recipeapp.databinding.ActivityRecipeDetailsBinding
import com.squareup.picasso.Picasso
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.GridLayoutManager
import at.ollmann.philipp.recipeapp.models.Recipe


class RecipeDetails : AppCompatActivity() {

    lateinit var binding: ActivityRecipeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecipeDetailsBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val recipe: Recipe? = intent.getSerializableExtra("recipe") as Recipe?

        recipe?.image?.let {
            Picasso.with(this)
                .load(it)
                .placeholder(R.drawable.ic_image)
                .into(binding.imageTitle)
        }

        binding.activityRecipeDetailsHealthLabel.text = recipe?.healthScore.toString() + " ${getResources().getString(
            R.string.health
        )}"
        binding.activityRecipeDetailsLikesLabel.text = recipe?.aggregateLikes.toString() + " ${getResources().getString(
            R.string.likes
        )}"
        binding.activityRecipeDetailsTimeLabel.text = recipe?.readyInMinutes.toString() + " ${getResources().getString(
            R.string.minutes
        )}"
        binding.activityRecipeDetailsTitle.text = recipe?.title
        binding.activityRecipeDetailsServingsLabel.text = "(" + recipe?.servings.toString() + " ${getResources().getString(
            R.string.servings
        )})"

        binding.buttonOpenRecipe.setOnClickListener{
            val uri: Uri = Uri.parse(recipe?.sourceUrl)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        if (recipe != null) {
            binding.activityRecipeDetailsIngredientsRecyclerView.layoutManager = GridLayoutManager(this, 1)
            binding.activityRecipeDetailsIngredientsRecyclerView.adapter = IngredientsRecyclerViewAdapter(this, recipe.extendedIngredients)
            binding.activityRecipeDetailsInstructionsRecyclerView.layoutManager = GridLayoutManager(this, 1)
            if(recipe.analyzedInstructions?.get(0)?.steps != null){
                binding.activityRecipeDetailsInstructionsRecyclerView.adapter = InstructionsRecyclerViewAdapter(this,
                    recipe.analyzedInstructions?.get(0)?.steps
                )
            }
        }
    }
}
