package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var mobile=""
        var email=""


        val dbHelper = DBHelper(applicationContext)
        val b2 = findViewById<Button>(R.id.b2)
        val ob2 = this.findViewById<Button>(R.id.ob2)
        val mtl1 = findViewById<TextInputLayout>(R.id.mtl1)
        val etl2 = findViewById<TextInputLayout>(R.id.etl2)
        mobile=  mtl1.editText?.text.toString()
        email=  etl2.editText?.text.toString()

        fun store(): Boolean? {
            return dbHelper.storedetails(
                mtl1.editText?.text.toString().trim(),
                etl2.editText?.text.toString().trim())
        }

        fun generateRandomNumber(): Int {
            val randomNumber = Random.nextInt(100000, 999999)
            return randomNumber
        }

        ob2.setOnClickListener{
            val number = generateRandomNumber()
            etl2.editText?.setText(number.toString())
        }

        b2.setOnClickListener {
            if (store() == true) {
                var intent = Intent(
                    this, MainActivity3::class.java
                ).apply {
                    putExtra("Refermobile", mobile)
                    putExtra("Referemail", email)
                }
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Invalid Details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}