package com.alarmas.src

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ProfileActivity : AppCompatActivity() {
    companion object{
        val user = UserData("juliana985@hotmail.com", "test123", "31-08-1998")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<EditText>(R.id.editTextDate).setText(user.bornDate)
        findViewById<EditText>(R.id.editTextTextEmailAddress).setText(user.email)
        val editProfileBtn = findViewById<Button>(R.id.button2)

        editProfileBtn.setOnClickListener{
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}