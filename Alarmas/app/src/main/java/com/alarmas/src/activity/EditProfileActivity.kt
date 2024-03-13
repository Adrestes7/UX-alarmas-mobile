package com.alarmas.src.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.alarmas.src.R

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        findViewById<EditText>(R.id.editTextDate).setText(ProfileActivity.user.bornDate)
        findViewById<EditText>(R.id.editTextTextEmailAddress).setText(ProfileActivity.user.email)
        findViewById<EditText>(R.id.editTextTextPassword).setText(ProfileActivity.user.password)

        val editProfileBtn = findViewById<Button>(R.id.button2)

        editProfileBtn.setOnClickListener{
            ProfileActivity.user.email = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            ProfileActivity.user.bornDate = findViewById<EditText>(R.id.editTextDate).text.toString()
            ProfileActivity.user.password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val cancelBtn = findViewById<Button>(R.id.button4)

        cancelBtn.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}