package com.alarmas.src.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.alarmas.src.model.CardView
import com.alarmas.src.R

class ListAdapter  // invoke the suitable constructor of the ArrayAdapter class
    (context: Context, arrayList: ArrayList<CardView?>?) :
    ArrayAdapter<CardView?>(context, 0, arrayList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // convertView which is recyclable view
        var currentItemView = convertView

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView =
                LayoutInflater.from(context).inflate(R.layout.list_title_layout, parent, false)
        }

        // get the position of the view from the ArrayAdapter
        val currentNumberPosition: CardView? = getItem(position)

        // then according to the position of the view assign the desired TextView 1 for the same
        if (currentNumberPosition != null) {
            currentItemView?.findViewById<TextView>(R.id.alarmTitle)?.text = currentNumberPosition.title
        }

        // then according to the position of the view assign the desired TextView 2 for the same
        if (currentNumberPosition != null) {
            currentItemView?.findViewById<TextView>(R.id.hora)?.text = currentNumberPosition.hora
        }

        // then return the recyclable view
        return currentItemView!!
    }
}