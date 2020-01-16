package id.co.iconpln.smartcity.ui.splash

import android.os.Bundle
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.login.LoginActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashViewHelper {


    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.setView(this)
        presenter.validateToken()
    }

    override fun navigateWelcomePage() {
        startActivity(LoginActivity.getIntent(this))
        finish()
    }

    override fun navigateHomePage() {

    }
}
