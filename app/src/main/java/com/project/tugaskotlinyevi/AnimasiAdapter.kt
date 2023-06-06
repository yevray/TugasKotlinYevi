package com.project.tugaskotlinyevi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AnimasiAdapter(private val listAnimasi : ArrayList<DataAnimasi>, val context: Context)
    : RecyclerView.Adapter<AnimasiAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_animasi, parent, false)
        return Holder(itemView);
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = listAnimasi[position]
        holder.icon_animasi.setImageResource(currentItem.iconAnimasi)
        holder.nama_animasi.text = currentItem.namaAnimasi

        holder.card.setOnClickListener(View.OnClickListener {
            val i = Intent(context, PreviewAnimasiActivity::class.java)
            i.putExtra("nama_anim", currentItem.namaAnimasi)
            context.startActivity(i)
        })
    }

    override fun getItemCount(): Int {
        return listAnimasi.size
    }

    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val card : CardView = itemView.findViewById(R.id.card)
        val icon_animasi : ImageView = itemView.findViewById(R.id.icon_animasi)
        val nama_animasi : TextView = itemView.findViewById(R.id.nama_animasi)

    }

}