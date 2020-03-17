package id.co.iconpln.smartcity.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.dashboard.DashboardActivity
import id.co.iconpln.smartcity.ui.login.LoginActivity
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            navigateWelcomePage()
//            navigatePengaduanPage()
        }, 2000)
    }

    private fun navigateWelcomePage() {
        startActivity(Intent(this, ProvinsiActivity::class.java))
        finish()
    }

    private fun navigatePengaduanPage() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

}
