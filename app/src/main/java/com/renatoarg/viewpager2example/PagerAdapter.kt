package com.renatoarg.viewpager2example

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class PagerAdapter(private val pagerMList: List<PagerM>) : RecyclerView.Adapter<ViewHolder?>() {

    internal inner class PagerViewHolder(itemView: View) : ViewHolder(itemView) {
        var txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        var img: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_row, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder = holder as PagerViewHolder
        val pagerM = pagerMList[position]
        viewHolder.txtDescription.text = pagerM.pagerDescription
        viewHolder.img.setImageBitmap(pagerM.image)
    }

    override fun getItemCount(): Int {
        return pagerMList.size
    }

}
