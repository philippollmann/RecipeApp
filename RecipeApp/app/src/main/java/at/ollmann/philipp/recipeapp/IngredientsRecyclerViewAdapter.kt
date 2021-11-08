package at.ollmann.philipp.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.ollmann.philipp.recipeapp.models.ExtendedIngredient

class IngredientsRecyclerViewAdapter(val context: Context, val ingredients: List<ExtendedIngredient>) : RecyclerView.Adapter<IngredientsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var ingredient: TextView
        var amount: TextView

        init {
            ingredient = itemView.findViewById(R.id.activity_recipe_detail_row_item_ingredient_label)
            amount = itemView.findViewById(R.id.activity_recipe_detail_row_item_ingredient_amount_label)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_recipe_details_ingredients_row_item, parent, false)
        return IngredientsRecyclerViewAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ingredient.text = ingredients[position].nameClean
        holder.amount.text = ingredients[position].amount.toString() + " " + ingredients[position].unit
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}