package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)
        val button2: Button = findViewById(R.id.button2)
        var counter = 0
        var increment = 1
        //var upgradeOrNot = false
        var hundredth = 100
        button.setOnClickListener(){

            button2.setOnClickListener(){
                //upgradeOrNot = true
                button2.visibility = View.INVISIBLE
                increment++
                hundredth = ((counter / 100) * 100) + 100
            }
            counter += increment
            textView.setText(counter.toString())

            if(counter >= hundredth){
                button2.setText("UPGRADE TO ADD " + (increment + 1).toString())
                button2.visibility = View.VISIBLE
            }


        }
    }
}