package com.example.kotlin_pr56

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_pr56.recept.Recept

class MyAdapter(private var recepts: List<Recept>)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.itemTextView)
        val textView2: TextView = view.findViewById(R.id.textView)
        val textView3: TextView = view.findViewById(R.id.textView2)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recepts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recept = recepts[position]
        holder.textView.text = recept.name
        holder.textView2.text = recept.id.toString()
        holder.textView3.text = recept.difficulty

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<Recept>) {
        recepts = newItems
        notifyDataSetChanged() // уведомление об изменениях
    }

}