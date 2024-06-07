package com.example.login_example.base.baseui

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.util.TypedValue
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidadvance.topsnackbar.TSnackbar
import com.example.login_example.R
import com.example.login_example.base.baseview.ProgressDialog
import com.example.login_example.ultil.AppEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        progressDialog = ProgressDialog(this)

    }

    fun onHideSoftKeyBoard() {
        val inputMng: InputMethodManager =
            this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMng.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }

    open fun showMessage(message: String, backgroundColor: Int, gravity: Int) {
        val snackbar =
            TSnackbar.make(findViewById(android.R.id.content), message, TSnackbar.LENGTH_LONG)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(backgroundColor)
        snackbarView.setPadding(
            0,
            resources.getDimensionPixelSize(R.dimen._40sdp),
            0,
            resources.getDimensionPixelSize(R.dimen._5sdp)
        )
        snackbarView.elevation = 0f
        val textView =
            snackbarView.findViewById<TextView>(com.androidadvance.topsnackbar.R.id.snackbar_text)
        textView.gravity = gravity
        val tf = Typeface.createFromAsset(this.assets, "fonts/PublicSans-Regular.ttf")
        textView.setTypeface(tf, Typeface.NORMAL)
        textView.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimensionPixelSize(R.dimen._14sdp).toFloat()
        )
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }

    open fun showErrorMessage(message: String?) {
        showErrorMessage(message, Gravity.CENTER)
    }

    open fun showAlertMessage(message: String?) {
        showAlertMessage(message, Gravity.CENTER)
    }

    open fun showErrorMessage(message: String?, gravity: Int) {
        showMessage(message!!, resources.getColor(R.color.red_tv_count_home), gravity)
    }

    open fun showAlertMessage(message: String?, gravity: Int) {
        showMessage(message!!, resources.getColor(R.color.colorAccent), gravity)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: Int){
        when (event) {
            AppEvent.TOKEN_EXPIRE -> {
                handleExpireToken()
            }
            AppEvent.USER_STATUS_CHANGE -> {

            }
            AppEvent.NETWORK_CONNECTED -> {

            }
        }

    }

    private fun handleExpireToken() {
        Toast.makeText(this, "Phiên đăng nhập đã hết hạn", Toast.LENGTH_SHORT).show()
        logOutUser()
    }

    private fun logOutUser(){
//        FirebaseManager.getInstance().removeListener()
    }
}