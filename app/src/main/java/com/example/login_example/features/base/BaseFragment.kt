package com.example.login_example.features.base

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.login_example.base.baseview.ProgressDialog

abstract class BaseFragment : Fragment() {

    private var baseActivity: BaseActivity? = null
    lateinit var progressDialog: ProgressDialog

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = try {
            context as BaseActivity
        } catch (exception: ClassCastException) {
            throw ClassCastException("Activity holder must extend BaseActivity")
        }
        progressDialog = ProgressDialog(context)
    }

    protected open fun showErrorMessage(message: String?) {
        baseActivity!!.showErrorMessage(message)
    }

    protected open fun showAlertMessage(message: String?) {
        baseActivity!!.showAlertMessage(message)
    }

    fun onHideSoftKeyBoard() {
        val inputMng: InputMethodManager =
            context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMng.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }

    fun showSoftKeyboard(view: View) {
        view.requestFocus()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        @Suppress("DEPRECATION")
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    open fun hideSoftKeyboard() {
        if (requireActivity().currentFocus != null) {
            val inputMethodManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                requireActivity().currentFocus!!.windowToken,
                0
            )
            requireActivity().currentFocus!!.clearFocus()
        }
    }


    protected val navController: NavController
        get() = NavHostFragment.findNavController(this)
}
