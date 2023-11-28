package com.example.noida1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val showregpage: TextView = findViewById(R.id.show_text_to_login)
        showregpage.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //On Register Button Click
        val buttonregistration: Button = findViewById(R.id.registration_submit)
        buttonregistration.setOnClickListener {
            val progressbar: ProgressBar = findViewById(R.id.progress_circular)
            progressbar.setVisibility(View.VISIBLE)
            val textshow_error_msg = findViewById<TextView>(R.id.show_error_msg)
            val url = "https://www.rushtrampolinpark.se/assets/class/register.php"



        }
    }
}