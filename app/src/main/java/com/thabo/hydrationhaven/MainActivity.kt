package com.thabo.hydrationhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //declarations
    private lateinit var textView: TextView
    private lateinit var waterlogo: ImageView
    private lateinit var ext_btn: Button
    private lateinit var nxt_btn: Button
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //making the button exit the app
        val ext_btn:Button= findViewById(R.id.ext_btn)
        ext_btn.setOnClickListener {
            finish()
        }


//making the button click to the next page
        val nxt_btn= findViewById<Button>(R.id.nxt_btn)
        nxt_btn.setOnClickListener {
            val Intent= Intent(this,MainActivity2::class.java)
            startActivity(Intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}