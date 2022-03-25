package com.example.ayudata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val botonReg:Button = findViewById(R.id.boton_regreso_info)

        botonReg.setOnClickListener {
            val intent = Intent(this, R.layout.activity_main::class.java)
            startActivity(intent)
        }
    }
}