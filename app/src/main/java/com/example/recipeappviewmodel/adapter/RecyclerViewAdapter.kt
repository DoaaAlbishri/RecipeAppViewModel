package com.example.recipeappviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeappviewmodel.MainActivity2
import com.example.recipeappviewmodel.R
import com.example.recipeappviewmodel.dataBase.RecipeDetails
import kotlinx.android.synthetic.main.item_row.view.*
//private var words: List<RecipeDetails>
class RecyclerViewAdapter(private val mainActivity2: MainActivity2) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView)
    private var words =  listOf<RecipeDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row
                        ,parent
                        ,false
                )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val word=words[position]
        holder.itemView.apply{
            tvTitle.text=word.title
            tvID.text= word.id.toString()
            tvAuthor.text=word.author
            tvIngredients.text=word.ingredients
            tvInstructions.text=word.instructions
            editBtn.setOnClickListener {
                mainActivity2.update(word.id)
            }
            delBtn.setOnClickListener {
                mainActivity2.delete(word.id)
            }
        }
    }
    override fun getItemCount(): Int =words.size

    fun update(words: List<RecipeDetails>){
        this.words = words
        notifyDataSetChanged()
   }
}