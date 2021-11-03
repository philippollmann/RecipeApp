package at.ollmann.philipp.recipeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val recipeList: Recipes) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var likes: TextView
        var minutes: TextView
        var price: TextView
        var health: TextView
        var title: TextView
        var imageView: ImageView

        init {
            likes = itemView.findViewById(R.id.activity_recipe_details_likes_label)
            price = itemView.findViewById(R.id.activity_recipe_details_price_label)
            minutes = itemView.findViewById(R.id.activity_recipe_details_time_label)
            health = itemView.findViewById(R.id.activity_recipe_details_health_label)

            title = itemView.findViewById(R.id.title)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)


        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.price.text = recipeList.results[position].pricePerServing.toString()
        holder.likes.text = recipeList.results[position].aggregateLikes.toString()
        holder.minutes.text = recipeList.results[position].readyInMinutes.toString()
        holder.health.text = recipeList.results[position].healthScore.toString()
        holder.title.text = recipeList.results[position].title

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, RecipeDetails::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("recipe", recipeList.results[position])
            it.context.startActivity(intent)
        }

        Picasso.with(this.context)
            .load(recipeList.results[position].image)
            .placeholder(R.drawable.ic_image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return recipeList.results.size;
    }
}