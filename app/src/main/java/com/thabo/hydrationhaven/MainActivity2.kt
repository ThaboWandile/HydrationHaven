package com.thabo.hydrationhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        //declarations
        val clear_btn = findViewById<Button>(R.id.clear_btn)
        val ext_btn = findViewById<Button>(R.id.ext_btn)
        val ave_btn = findViewById<Button>(R.id.ave_btn)
        val nxtBtn = findViewById<Button>(R.id.nxt_btn)
        val amLiters= findViewById<TextView>(R.id.amLiters)
        val pmLiters= findViewById<TextView>(R.id.pmLiters)


        //initialize them
        var i: Int= 0
        var display : String= ""
        val maxEntries = 7

        var averageAm : Int = 0
        var averagePm : Int = 0
        var averageTotal : Int= 0
        var displayAverage : String= ""

        // creating arrays
        var day = Array(maxEntries) {""}
        var morningIntake = Array(maxEntries) {0}
        var afternoonIntake = Array(maxEntries) {0}





        //making the button click to the next page
       nxtBtn.setOnClickListener {
           display = ""
           for (counter in 0 until i){
               display += "Date: ${day[counter]}"
               averageAm += morningIntake [counter]
               averagePm += afternoonIntake [counter]
       }
averageTotal /= i
           averageAm /=i
           averagePm /= i

           displayAverage = "Average Intake(AM): $(morningTime[counter]}\nPM Time:$(afternoonTime[counter]}"
           display += displayAverage

           // passing the data to the next page
           val intent = Intent(this, MainActivity3::class.java)
           startActivity(intent)

// clear the text views
            clear_btn.setOnClickListener {
            amLiters.text = ""
            pmLiters.text = ""

            }
            //making the button exit the app
            val ext_btn: Button = findViewById(R.id.ext_btn)
            ext_btn.setOnClickListener {
                finish()
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}