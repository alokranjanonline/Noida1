package com.example.noida1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.noida1.ui.theme.Noida1Theme
import com.example.noida1.Session.LoginPref

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonotheractivity: Button = findViewById(R.id.btnAnotherActivity)
        buttonotheractivity.setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
        }
        val buttonlogin: Button = findViewById(R.id.btnLoginActivity)
        buttonlogin.setOnClickListener {
            val intentlogin = Intent(this, LoginActivity::class.java)
            startActivity(intentlogin)
        }
        val buttonregister: Button = findViewById(R.id.btnRegisterActivity)
        buttonregister.setOnClickListener {
            val intentregister = Intent(this, RegistrationActivity::class.java)
            startActivity(intentregister)
        }

        //Test Global variable//
        //val check_global_val: TextView = findViewById(R.id.check_global_value)
        //check_global_val.text  = GlobalActivity.check_session

    }
    override fun onStart() {
        super.onStart()


        /*val check_global_val: TextView = findViewById(R.id.check_global_value)
        if(check_global_val.text=="true"){
            val intent = Intent(this, LoraActivity::class.java)
            startActivity(intent)
        }*/
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Noida1Theme {
        Greeting("Android")
    }
}