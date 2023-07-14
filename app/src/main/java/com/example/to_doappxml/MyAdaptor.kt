package com.example.to_doappxml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdaptor(private val dataSet: ArrayList<String>, private val descriptionsSet: ArrayList<String>) : RecyclerView.Adapter<MyAdaptor.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myTextView: TextView = itemView.findViewById<TextView>(R.id.textNote)
        val myDescriptionView: TextView = itemView.findViewById<TextView>(R.id.descriptionNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myTextView.text = dataSet[position]

        holder.myDescriptionView.text = descriptionsSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}