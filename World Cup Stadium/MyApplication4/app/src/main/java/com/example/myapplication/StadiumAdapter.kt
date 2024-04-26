package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StadiumAdapter(
    private val stadiumList: List<Stadium>,
    private val stadiumCountListener: (Int) -> Unit) :
    RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    inner class StadiumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageStadium: ImageView = itemView.findViewById(R.id.imageStadium)
        val textStadiumName: TextView = itemView.findViewById(R.id.textStadiumName)
        val textLocationCapacity: TextView = itemView.findViewById(R.id.textCapacity)
        val textStadiumLocation: TextView = itemView.findViewById(R.id.textStadiumLocation)
        val buttonLike: Button = itemView.findViewById(R.id.buttonLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_stadium, parent, false)
        return StadiumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        val currentStadium = stadiumList[position]

        holder.imageStadium.setImageResource(currentStadium.imageResId)
        holder.textStadiumName.text = currentStadium.name
        holder.textLocationCapacity.text = currentStadium.capacity
        holder.textStadiumLocation.text = currentStadium.location

        holder.buttonLike.setOnClickListener {
            val toastMessage = "You liked the ${currentStadium.name}. Hope to see you there"
            Toast.makeText(holder.itemView.context, toastMessage, Toast.LENGTH_SHORT).show()
        }

        stadiumCountListener.invoke(stadiumList.size)
    }

    override fun getItemCount(): Int {
        return stadiumList.size
    }
}