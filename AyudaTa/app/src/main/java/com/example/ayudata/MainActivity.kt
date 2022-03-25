package com.example.ayudata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonEscuchar: Button = findViewById(R.id.escucharButton)
        val botonContactos: Button = findViewById(R.id.contactosButton)
        val botonLlamada: Button = findViewById(R.id.llamadaButton)
        val botonInfo: Button = findViewById(R.id.InfoButton)
        val botonUbicacion: Button = findViewById(R.id.ubicacionButton)

        botonEscuchar.setOnClickListener {
            val intent = Intent(this, activity_escuchar::class.java)
            startActivity(intent)
        }

        botonContactos.setOnClickListener{
            val intent = Intent(this, activity_contactos::class.java)
            startActivity(intent)
        }

        botonLlamada.setOnClickListener{
            val intent = Intent(this, activity_llamada::class.java)
            startActivity(intent)
        }

        botonInfo.setOnClickListener{
            val intent = Intent(this, activity_info::class.java)
            startActivity(intent)
        }

        botonUbicacion.setOnClickListener{
            val intent = Intent(this, activity_ubicacion::class.java)
            startActivity(intent)
        }
    }
}