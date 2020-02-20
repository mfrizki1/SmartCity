package id.co.iconpln.smartcity.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.LoginDto
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.kota.KotaActivity
import id.co.iconpln.smartcity.ui.kota.KotaActivity.Companion.GET_ID_CITY
import id.co.iconpln.smartcity.ui.kota.KotaActivity.Companion.GET_NAME_CITY
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity.Companion.GET_ID_PROV
import id.co.iconpln.smartcity.ui.publicservices.PublicServicesFragment
import id.co.iconpln.smartcity.util.ValidatorUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginViewHelper {


    @Inject
    lateinit var presenter: LoginPresenter
    @Inject
    lateinit var validator: ValidatorUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupActionBarWithBackButton(toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra(GET_NAME_CITY)

        presenter.setView(this)

        val intent = getIntent()
        val getIdCity = intent.getStringExtra(GET_ID_CITY)
        validator.setOnValidationListener {
            presenter.login(ed_username.text!!, getIdCity, ed_password.text!!)
        }
        validator.registerView(ed_username)
        validator.registerView(ed_password)

        btn_login.setOnClickListener {
            validator.validate()
            Toast.makeText(applicationContext, "memilih " + getIdCity, Toast.LENGTH_SHORT).show()
        }

    }

    override fun doLogin(loginDto: ArrayList<LoginDto>) {
        btn_login.isLoading = true

        startActivity(Intent(this, PublicServicesFragment::class.java))

    }

    override fun hideButtonProgress() {
        btn_login.isLoading = false
    }



}
