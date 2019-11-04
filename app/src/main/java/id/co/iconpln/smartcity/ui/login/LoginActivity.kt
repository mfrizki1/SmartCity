package id.co.iconpln.smartcity.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.util.ValidatorUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginViewHelper {
    @Inject
    lateinit var presenter: LoginPresenter
    @Inject
    lateinit var validator: ValidatorUtils

    companion object {
        fun getIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupActionBarWithBackButton(toolbar)

        presenter.setView(this)

        validator.setOnValidationListener {
            presenter.login(txt_email.text.toString(), txt_password.text.toString())
        }
        validator.registerView(txt_email)
        validator.registerView(txt_password)

        btn_login.setOnClickListener { validator.validate() }

    }

    override fun showButtonProgress() {
        btn_login.isLoading = true
    }

    override fun hideButtonProgress() {
        btn_login.isLoading = false
    }



}
