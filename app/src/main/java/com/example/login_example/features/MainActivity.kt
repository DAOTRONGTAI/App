package com.example.login_example.features

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.login_example.R
import com.example.login_example.features.login.account.login.LoginActivity
import com.example.login_example.ultil.firebase.MyFirebaseMessagingService
import com.example.login_example.ultil.Constant
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var drawerLayout: DrawerLayout? = null
    var toolbar: Toolbar? = null

    var mCurrentFragment: Int = Constant.FRAGMENT_LOGIN
    private val mFragmentManager: FragmentManager? = null
    private val mFirebase = MyFirebaseMessagingService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.layout_drawer)
        toolbar = findViewById(R.id.toolbar_tutorial)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_drawer_open,
            R.string.nav_drawer_close
        )
        with(drawerLayout) { this?.addDrawerListener(toggle) }
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.navigate_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun navigateFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_content, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_login) {
            goLogin()
        } else if (id == R.id.nav_login_1) {
        }
        return true
    }


    private fun goLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goCalendar() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goProfile() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goNoteApp() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goCalculator() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}