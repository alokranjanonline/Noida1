package com.example.noida1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley



class LoginActivity : ComponentActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var email = ""
    var pwd = ""
    var PREFS_KEY = "prefs"
    var EMAIL_KEY = "email"
    var PWD_KEY = "pwd"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Check session //
        //val check_seesion: TextView = findViewById(R.id.check_session_on_login_act)
        //check_seesion.text="false"
        if(GlobalActivity.check_session=="true"){
            val intent = Intent(this, LoraActivity::class.java)
            startActivity(intent)
        }
        //Go to Registration page
        val showregpage: TextView = findViewById(R.id.show_text_to_register)
        showregpage.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        // End Go to Registration page

        // Login Button Click Action
        val textInputEditTextEmail:TextView  = findViewById(R.id.login_email)
        val textInputEditTextPassword:TextView = findViewById(R.id.login_password)
        val textshow_error_msg = findViewById<TextView>(R.id.show_error_msg)
        val buttonlogin: Button = findViewById(R.id.submit)
        val queue = Volley.newRequestQueue(this)
        //val url = "http://www.sportainmentdesign.com/"
        //val username="brainspree"
        //val password="c8311c58f77fc3fd05831aaaf0583ab712cd7381"
        //val url = "https://www.rushtrampolinpark.se/assets/class/" +
        //        "login.php?login_email="+username+"&password="+password


        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(EMAIL_KEY, "").toString()
        pwd = sharedPreferences.getString(PWD_KEY, "").toString()

        buttonlogin.setOnClickListener {
            // Request a string response from the provided URL.
            /*val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
            val network = BasicNetwork(HurlStack())
            val requestQueue = RequestQueue(cache, network).apply {
                start()
            }*/
            val username1 = findViewById<EditText>(R.id.login_email)
            val password1 = findViewById<EditText>(R.id.login_password)
            var username = username1.text.toString()
            var password = password1.text.toString()
            val url = "https://www.southernplus.com/test/login.php?user_name="+username+"&password="+password

            val progressbar:ProgressBar = findViewById(R.id.progress_circular)
            progressbar.setVisibility(View.VISIBLE);
            Toast.makeText(this, textInputEditTextEmail.text, Toast.LENGTH_SHORT).show()
            val stringRequest = StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response ->
                    //textshow_error_msg.text = "Response is: ${response}"
                    textshow_error_msg.text = response
                    if(response.equals  ("success")){
                        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                        progressbar.setVisibility(View.INVISIBLE);


                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString(EMAIL_KEY, username)
                        editor.putString(PWD_KEY, password)
                        editor.apply()
                        GlobalActivity.check_session="true"
                        val intent = Intent(this, LoraActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                        progressbar.setVisibility(View.INVISIBLE);
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                },
                Response.ErrorListener { textshow_error_msg.text = "Login Failed" })
                // Add the request to the RequestQueue.
            queue.add(stringRequest)

        }
        
    }

    // on below line we are calling on start method.
    override fun onStart() {
        super.onStart()
        val textshow_error_msg = findViewById<TextView>(R.id.check_session_on_login_act)
        textshow_error_msg.text = email+pwd
        // in this method we are checking if email and pwd are not empty.
        if (!email.equals("") && !pwd.equals("")) {
            // if email and pwd is not empty we
            // are opening our main 2 activity on below line.
            val i = Intent(this, LoraActivity::class.java)

            // on below line we are calling start
            // activity method to start our activity.
            startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
            finish()
        }
    }



}