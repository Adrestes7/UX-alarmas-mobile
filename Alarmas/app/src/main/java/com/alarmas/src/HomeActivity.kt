package com.alarmas.src

import ListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    var data = arrayListOf<CardView?>(CardView("4:30", "gym", "diaria"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.button).setOnClickListener {
            val popup = PopupMenu(this, it)
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

        val listView = findViewById<ListView>(R.id.list)
        val adapter = ListAdapter(this,data)



        listView.adapter = adapter
    }

    fun navigateToProfile(){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

}