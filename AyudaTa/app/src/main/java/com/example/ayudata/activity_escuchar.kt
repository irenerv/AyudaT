package com.example.ayudata

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.createOnDeviceSpeechRecognizer
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.ArrayList

class activity_escuchar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escuchar)

        val botonEscuchar:Button = findViewById(R.id.btn_tts)
        lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
        val textoPlano:EditText = findViewById(R.id.et_text_input)
        botonEscuchar.setOnClickListener(View.OnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Di algo")
            try {
                activityResultLauncher.launch(intent)
            }catch (exp:ActivityNotFoundException){
                Toast.makeText(applicationContext, "Dispositivo no soportado", Toast.LENGTH_SHORT).show()

            }
        })

        activityResultLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult? ->
            if(result!!.resultCode == RESULT_OK && result!!.data!=null){
                val speectext = result!!.data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<Editable>

                textoPlano.setText(speectext[0])
            }
        }

    }
}

