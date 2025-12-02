package com.aziz.fristapk

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cardactivity : AppCompatActivity() {

    //Langkah 1,membuat inisiasi
    private lateinit var cvMainHome: CardView
    private lateinit var cvMainFood: CardView
    private lateinit var cvMainDrink: CardView
    private lateinit var cvMainRating: CardView
    private lateinit var cvMainHelp: CardView
    private lateinit var cvMainExit: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cardactivity)

        init()

        // === CARD HOME ===
        cvMainHome.setOnClickListener {
            startActivity(Intent(this, RelatifActivity::class.java))

            val intent = Intent(this@Cardactivity, RelatifActivity::class.java)
            intent.putExtra("Nama", "Aziz")
            intent.putExtra("Alamat", "Tegal Kembang")
            startActivity(intent)

            Toast.makeText(this@Cardactivity, "Card view Home Diklik", Toast.LENGTH_SHORT).show()
        }

        cvMainFood.setOnClickListener {
            startActivity(Intent(this, FoodActifity::class.java))
            Toast.makeText(this@Cardactivity, "Ini Food Card", Toast.LENGTH_SHORT).show()
        }

        cvMainDrink.setOnClickListener {
            startActivity(Intent(this, KonversiSuhu::class.java))
            Toast.makeText(this@Cardactivity, "Ini Drink Card", Toast.LENGTH_SHORT).show()
        }

        cvMainRating.setOnClickListener {
            startActivity(Intent(this, Kalkulator::class.java))
            Toast.makeText(this@Cardactivity, "Ini Rating Card", Toast.LENGTH_SHORT).show()
        }

        cvMainHelp.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
            Toast.makeText(this@Cardactivity, "Ini Help Card", Toast.LENGTH_SHORT).show()
        }

        // === CARD EXIT (MEMBUKA POPUP EXIT) ===
        cvMainExit.setOnClickListener {
            showExitDialog()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        cvMainHome = findViewById(R.id.cardHome)
        cvMainFood = findViewById(R.id.cardFood)
        cvMainDrink = findViewById(R.id.cardDrink)
        cvMainRating = findViewById(R.id.cardRating)
        cvMainHelp = findViewById(R.id.cardHelp)
        cvMainExit = findViewById(R.id.cardExit)
    }

    // ========== POPUP EXIT ==========
    private fun showExitDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.activity_exit_card)   // layout dialog yang sudah kamu buat
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnLanjut = dialog.findViewById<Button>(R.id.btnLanjut)
        val btnTidak = dialog.findViewById<Button>(R.id.btnTidak)

        btnLanjut.setOnClickListener {
            finishAffinity()   // keluar aplikasi
        }

        btnTidak.setOnClickListener {
            dialog.dismiss()   // tutup popup
        }

        dialog.show()
    }
}
