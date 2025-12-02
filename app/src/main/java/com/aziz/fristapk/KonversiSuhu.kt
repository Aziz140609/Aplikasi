package com.aziz.fristapk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KonversiSuhu : AppCompatActivity() {

    private lateinit var spSuhu1: Spinner;
    private lateinit var spSuhu2: Spinner;
    private lateinit var etSuhu: EditText;
    private lateinit var tvHasil: TextView;
    private lateinit var btnKonversi: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)

        init()
        btnKonversi.setOnClickListener {


            val Suhu1 = spSuhu1.selectedItem?.toString()
            val Suhu2 = spSuhu2.selectedItem?.toString()
            val Suhu = etSuhu.text.toString().toDoubleOrNull()

            if (Suhu == null) {
                tvHasil.error = "Masukkan nilai suhu yang valid!"
                return@setOnClickListener
            }

            var hasil = 0.0

            if (Suhu1 == "Celcius") {

                if (Suhu2 == "Fahrenheit"){
                    hasil = Suhu * 9/5 + 32

                } else if (Suhu2 == "Kelvin"){
                    hasil = Suhu + 273.15

                } else {
                    hasil = Suhu
                }
            }

            if (Suhu1 == "Fahrenheit") {

                if (Suhu2 == "Celcius"){
                    hasil = (Suhu - 32) * 5/9

                } else if (Suhu2 == "Kelvin"){
                    hasil = (Suhu - 32) * 5/9 + 273.15

                } else {
                    hasil = Suhu
                }
            }

            if (Suhu1 == "Kelvin") {

                if (Suhu2 == "Fahrenheit"){
                    hasil = (Suhu - 273.15) * 9/5 + 32

                } else if (Suhu2 == "Celcius"){
                    hasil = Suhu - 273.15

                } else {
                    hasil = Suhu
                }
            }



            tvHasil.text = hasil.toString()

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init(){
        spSuhu1 = findViewById(R.id.spSuhu1)
        spSuhu2 = findViewById(R.id.spSuhu2)
        etSuhu = findViewById(R.id.etSuhu)
        tvHasil = findViewById(R.id.tvHasil)
        btnKonversi = findViewById(R.id.btnKonversi)
    }

}