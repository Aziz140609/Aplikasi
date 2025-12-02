package com.aziz.fristapk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoodActifity : AppCompatActivity() {

    private lateinit var etNamaCustomer: EditText
    private lateinit var btnPesan: Button
    private lateinit var etBakso: EditText
    private lateinit var etMieAyam: EditText
    private lateinit var etTeh: EditText
    private lateinit var etJeruk: EditText
    private lateinit var spTeh: Spinner
    private lateinit var spJeruk: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_actifity)
        init()

        btnPesan.setOnClickListener {

            val nama = etNamaCustomer.text.toString().trim()
            if (nama.isEmpty()) {
                etNamaCustomer.error = "Nama harus diisi!"
                return@setOnClickListener
            }

            val bakso = etBakso.text.toString().ifEmpty { "0" }
            val mieAyam = etMieAyam.text.toString().ifEmpty { "0" }
            val teh = etTeh.text.toString().ifEmpty { "0" }
            val jeruk = etJeruk.text.toString().ifEmpty { "0" }

            val SuhuTeh = spTeh.selectedItem?.toString() ?: "Dingin"
            val SuhuJeruk = spJeruk.selectedItem?.toString() ?: "Dingin"

            val intent = Intent(this, Nota::class.java)
            intent.putExtra("Nama", nama)
            intent.putExtra("Bakso", bakso)
            intent.putExtra("MieAyam", mieAyam)
            intent.putExtra("Teh", teh)
            intent.putExtra("Jeruk", jeruk)
            intent.putExtra("SuhuTeh", SuhuTeh)
            intent.putExtra("SuhuJeruk", SuhuJeruk)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        etNamaCustomer = findViewById(R.id.etNamaCustomer)
        btnPesan = findViewById(R.id.btnPesan)
        etBakso = findViewById(R.id.etJmlBakso)
        etMieAyam = findViewById(R.id.etJmlMieAyam)
        etTeh = findViewById(R.id.etJmlTeh)
        etJeruk = findViewById(R.id.etJmlAirJeruk)
        spTeh = findViewById(R.id.spTeh)
        spJeruk = findViewById(R.id.spAirJeruk)
    }
}
