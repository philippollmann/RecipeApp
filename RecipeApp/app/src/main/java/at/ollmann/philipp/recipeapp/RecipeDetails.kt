package at.ollmann.philipp.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.ollmann.philipp.recipeapp.databinding.ActivityRecipeDetailsBinding
import com.squareup.picasso.Picasso
import android.content.Intent
import android.net.Uri


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

        binding.activityRecipeDetailsHealthLabel.text = recipe?.healthScore.toString() + " ${getResources().getString(R.string.health)}"
        binding.activityRecipeDetailsLikesLabel.text = recipe?.aggregateLikes.toString() + " ${getResources().getString(R.string.likes)}"
        binding.activityRecipeDetailsTimeLabel.text = recipe?.readyInMinutes.toString() + " ${getResources().getString(R.string.minutes)}"
        binding.activityRecipeDetailsTitle.text = recipe?.title

        binding.buttonOpenRecipe.setOnClickListener{
            val uri: Uri = Uri.parse(recipe?.sourceUrl)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
