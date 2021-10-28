package com.example.menuApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val botonsalir = findViewById<Button>(R.id.bT3)
        val tV2 = findViewById<TextView>(R.id.tV2)

        tV2.text=""

        // Get the Intent that started this activity and extract the string

        // Get the Intent that started this activity and extract the string
        //var intent = getIntent();
        //var message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text

        // Capture the layout's TextView and set the string as its text
       // val textView = findViewById<TextView>(R.id.tV2)
       // textView.text = message


        // Get the Intent that started this activity and extract the string

        val strUser = intent.getStringExtra("seleccionDeMenu")
        tV2.setText(strUser)


        botonsalir.setOnClickListener{
            finish()
        }
    }
}