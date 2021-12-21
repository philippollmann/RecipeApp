package at.ollmann.philipp.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.ollmann.philipp.recipeapp.models.Step

class InstructionsRecyclerViewAdapter(val context: Context, val instructions: List<Step>?) : RecyclerView.Adapter<InstructionsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var instructionTitle: TextView
        var instructionText: TextView

        init {
            instructionTitle = itemView.findViewById(R.id.activity_recipe_instruction_row_item_title)
            instructionText = itemView.findViewById(R.id.activity_recipe_instruction_row_item_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_recipe_details_instruction_row_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(instructions != null){
            holder.instructionTitle.text = "Step " + instructions[position].number.toString()
            holder.instructionText.text = instructions[position].step
        }
    }

    override fun getItemCount(): Int {
        if(instructions != null){
            return instructions.size
        } else {
            return 0
        }
    }
}