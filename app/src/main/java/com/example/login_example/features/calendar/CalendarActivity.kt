package com.example.login_example.features.calendar

import android.os.Bundle
import com.example.login_example.R
import com.example.login_example.base.baseui.BaseActivity

class CalendarActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        supportActionBar!!.hide()
    }
}