package id.co.iconpln.smartcity.ui.base

import android.app.LauncherActivity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import dagger.android.AndroidInjection
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.widget.AlertDialogCenter
import id.co.iconpln.smartcity.widget.TopSnackbar
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * rizmaulana@live.com 2019-06-14.
 */
abstract class BaseActivity : AppCompatActivity(), BaseViewHelper {

    var progressDialog: ProgressDialog? = null


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        changeStatusBarWhite()
    }

    override fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.show()
            if (progressDialog?.window != null) {
                progressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog?.setContentView(R.layout.layout_progress_dialog)
            progressDialog?.isIndeterminate = true
            progressDialog?.setCancelable(false)
            progressDialog?.setCanceledOnTouchOutside(false)
        } else {
            progressDialog?.show()
        }
    }

    override fun hideProgress() {
        progressDialog?.dismiss()
    }

    override fun showSnackbarMessage(message: String?) {
        message?.let {
            val container = findViewById<CoordinatorLayout>(R.id.layout_content)
            if (container != null) {
                showTopSnackbar(container, it, R.color.prince_ton_orange)
            } else {
                showTopSnackbar(window.decorView.rootView, it, R.color.prince_ton_orange)
            }
        }
    }

    override fun showSnackbarError(message: String?) {
        message?.let {
            val container = findViewById<CoordinatorLayout>(R.id.layout_content)
            if (container != null) {
                showTopSnackbar(container, it, R.color.red)
            } else {
                showTopSnackbar(window.decorView.rootView, it, R.color.red)
            }
        }
    }

    override fun onUnexpectedError() {
        hideProgress()
        showSnackbarError(getString(R.string.msg_unexpected_error))
    }

    override fun showAlertDialog(message: String?) {
        val dialog = AlertDialogCenter()
        dialog.message = message
        dialog.positiveButton = resources.getString(R.string.action_ok)
        dialog.show(supportFragmentManager)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    override fun onAuthFailed() {
        val dialog = AlertDialogCenter()
        dialog.message = getString(R.string.message_user_unautorizhed)
        dialog.positiveButton = resources.getString(R.string.action_ok)
        dialog.positiveButtonListener = object : AlertDialogCenter.OnClickListener {
            override fun onClick() {
                val intent = Intent(applicationContext, LauncherActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finishAffinity()
            }
        }
        dialog.show(supportFragmentManager)
    }

    private fun showTopSnackbar(root: View, message: String, @ColorRes color: Int) {
        val topSnackbar = TopSnackbar.make(root, message, TopSnackbar.LENGTH_LONG)
        val snackbarView = topSnackbar.getView()
        snackbarView.setBackgroundColor(ContextCompat.getColor(this, color))
        val textView = snackbarView.findViewById(R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        topSnackbar.show()
    }

    private fun hideSoftKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        val view = this.currentFocus
        if (view != null) {
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    open fun setupActionBarWithBackButton(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        toolbar.setTitleTextAppearance(this, R.style.TextAppearance_App_TextView_Toolbar)
    }

    open fun changeStatusBarWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
    }
}