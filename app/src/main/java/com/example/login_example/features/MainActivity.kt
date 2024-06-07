package com.example.login_example.features

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.login_example.R
import com.example.login_example.base.baseui.BaseActivity
import com.example.login_example.features.account.login.LoginActivity
import com.example.login_example.ultil.firebase.MyFirebaseMessagingService
import com.example.login_example.ultil.Constant
import com.google.android.material.navigation.NavigationView

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}