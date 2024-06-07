package com.example.login_example.base.baseview

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.login_example.R
import com.example.login_example.databinding.ProgressDialogBinding

class ProgressDialog (private val context: Context) {

    lateinit var dialog: CustomDialog
    lateinit var binding: ProgressDialogBinding

    fun dismiss() {
        try{ dialog.dismiss() } catch (e: Exception) {}
    }

    fun show(): Dialog {
        val inflater = (context as Activity).layoutInflater
        val view = inflater.inflate(R.layout.progress_dialog, null)

        binding.cardView.setCardBackgroundColor(Color.parseColor("#26000000"))
        setColorFilter(
            binding.progressBar.indeterminateDrawable,
            ResourcesCompat.getColor(context.resources, R.color.colorAccent, null)
        )

        dialog = CustomDialog(context).apply {
//            setContentView(view)
            setContentView(binding.root)
            show()
        }
        return dialog
    }

    private fun setColorFilter(drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }

    class CustomDialog(context: Context) : Dialog(context, R.style.CustomDialogTheme) {
        init {
            // Set Semi-Transparent Color for Dialog Background
            window?.decorView?.rootView?.setBackgroundResource(android.R.color.transparent)
            window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                insets.consumeSystemWindowInsets()
            }
        }
    }
}