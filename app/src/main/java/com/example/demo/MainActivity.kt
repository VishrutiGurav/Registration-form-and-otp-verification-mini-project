package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(applicationContext)
        val b1 = findViewById<Button>(R.id.b1)
        val tl1 = findViewById<TextInputLayout>(R.id.tl1)
        val tl2 = findViewById<TextInputLayout>(R.id.tl2)
        val tl3 = findViewById<TextInputLayout>(R.id.tl3)
        val tl4 = findViewById<TextInputLayout>(R.id.tl4)
        val tl5 = findViewById<TextInputLayout>(R.id.tl5)
        val tl6 = findViewById<TextInputLayout>(R.id.tl6)
        val tl7 = findViewById<TextInputLayout>(R.id.tl7)
        val tl8 = findViewById<TextInputLayout>(R.id.tl8)
        val tl9 = findViewById<TextInputLayout>(R.id.tl9)
        fun register(): Boolean? {
            return dbHelper.registerUser(
                tl1.editText?.text.toString(),
                tl2.editText?.text.toString().trim(),
                tl3.editText?.text.toString().trim(),
                tl4.editText?.text.toString().trim(),
                tl5.editText?.text.toString().trim(),
                tl6.editText?.text.toString().trim(),
                tl7.editText?.text.toString().trim(),
                tl8.editText?.text.toString().trim(),
                tl9.editText?.text.toString().trim())

        }
        b1.setOnClickListener {
            val viewDBIntent = Intent(this, MainActivity2::class.java)

            if (register() == true) {
                Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT)
                    .show()
                startActivity(viewDBIntent)
            } else {
                Toast.makeText(applicationContext, "Unable to register!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
