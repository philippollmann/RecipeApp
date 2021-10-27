package at.ollmann.philipp.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val recipeList: Recipes) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var title: TextView
        var imageView: ImageView

        init {
            userId = itemView.findViewById(R.id.userId)
            title = itemView.findViewById(R.id.title)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = recipeList.results[position].sourceUrl
        holder.title.text = recipeList.results[position].title
        Picasso.with(this.context)
            .load(recipeList.results[position].image)
            .placeholder(R.drawable.ic_image)
            .into(holder.imageView)
        //holder.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    }

    override fun getItemCount(): Int {
        return recipeList.results.size;
    }
}