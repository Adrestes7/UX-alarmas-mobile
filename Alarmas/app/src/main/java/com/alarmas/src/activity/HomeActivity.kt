package com.alarmas.src.activity

import com.alarmas.src.adapter.ListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.alarmas.src.R
import com.alarmas.src.model.CardView


class HomeActivity : AppCompatActivity() {
    var data = arrayListOf<CardView?>(CardView("4:30", "gym", "diaria"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val listView = findViewById<ListView>(R.id.list)
        val adapter = ListAdapter(this,data)



        listView.adapter = adapter
    }

    fun navigateToProfile(){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    fun goToProfile(view: View) {
            val popup = PopupMenu(this, view)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_file, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                if(item.title?.equals("Perfil") == true){
                    navigateToProfile()
                }
                true
            }
            popup.show()
        }


}