package com.alarmas.src.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.alarmas.src.R
import android.widget.Toast
import java.util.*

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextBirthDate: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonGoToLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        // Inicialización de los EditText
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextBirthDate = findViewById(R.id.editTextBirthDate)

        // Inicialización de los botones
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonGoToLogin = findViewById(R.id.buttonGoToLogin)

        editTextBirthDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                this@CreateAccountActivity,
                { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = "${dayOfMonth.twoDigits()}-${(monthOfYear + 1).twoDigits()}-$year"
                    editTextBirthDate.setText(selectedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString()
            val birthDate = editTextBirthDate.text.toString().trim()

            // Verifica que ninguno de los campos esté vacío
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || birthDate.isEmpty()) {
                // Muestra un mensaje de error o maneja la validación como prefieras
                Toast.makeText(this, "Todos los campos son obligatorios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verifica que el email tenga el formato correcto (esto es una validación básica)
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Por favor, introduce un email válido.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val verificationIntent = Intent(this, VerificationActivity::class.java)
            startActivity(verificationIntent)
        }

    }

    private fun Int.twoDigits() = this.toString().padStart(2, '0')
}
