package com.platzi.kotlinyjava

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var edtxtPass: EditText
    lateinit var edtxtUser: EditText
    lateinit var btnLogin: Button

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtxtPass = findViewById<View>(R.id.edtxLoginPassw) as EditText
        edtxtUser= findViewById<View>(R.id.edtxLoginUsuario) as EditText
        btnLogin = findViewById<View>(R.id.btnLogin) as Button

        val sharedPreferences = getSharedPreferences("kotlinpre", Context.MODE_PRIVATE)

        val isLogged = sharedPreferences.getBoolean("loggeado", false)

        if(isLogged){
            startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
            finish()
        }


        btnLogin.setOnClickListener {
            val isValid = edtxtPass.passwordValida()
            Log.e(TAG, "onClick: $isValid")
            if (isValid) {
                //startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
                val intent = Intent(this@MainActivity, ListadoActivity::class.java)
                intent.putExtra("usuario", edtxtUser.text.toString())
                startActivity(intent)
                sharedPreferences.edit {
                    putBoolean("loggeado", true)
                }
            } else {
                Toast.makeText(this@MainActivity, "Password Invalida", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

}