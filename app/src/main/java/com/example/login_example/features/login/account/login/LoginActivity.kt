package com.example.login_example.features.login.account.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login_example.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
    }
}