package com.alarmas.src.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.alarmas.src.R

class VerificationActivity : AppCompatActivity() {
    private lateinit var editTextVerificationCode: EditText
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        editTextVerificationCode = findViewById(R.id.editTextVerificationCode)
        buttonNext = findViewById(R.id.buttonNext)

        // Aquí se implementará la lógica para verificar el código
        buttonNext.setOnClickListener {
        }
    }
}
