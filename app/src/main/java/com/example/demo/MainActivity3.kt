package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var obtainmobile: String
        var obtainemail: String

        val t1 = this.findViewById<TextView>(R.id.t1)
        val t2 = this.findViewById<TextView>(R.id.t2)
        val tb1 = this.findViewById<Button>(R.id.tb1)
        val b3 = this.findViewById<Button>(R.id.b3)

        obtainmobile = intent.getStringExtra("Refermobile").toString()
        obtainemail = intent.getStringExtra("Referemail").toString()

        t1.text=obtainmobile
        t2.text=obtainemail

        object : CountDownTimer(30000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                tb1.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                t1.setText("Done!")
                tb1.setText("Resend code")
            }
        }.start()


    }

    }
