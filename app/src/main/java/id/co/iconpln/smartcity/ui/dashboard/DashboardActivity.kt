package id.co.iconpln.smartcity.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.ekonomi.EkonomiFragment
import id.co.iconpln.smartcity.ui.publicservices.PublicServicesFragment
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*

class DashboardActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var Bottom_menu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        Bottom_menu = findViewById(R.id.Bottom_menu)
        Bottom_menu.setOnNavigationItemSelectedListener(this)

        if(savedInstanceState == null){
            Bottom_menu.setSelectedItemId(R.id.nav_home)
        }

        setSupportActionBar(toolbar)
//        supportActionBar?.title =
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        var fragment: Fragment? = null
        when (item.itemId){
            R.id.nav_home ->{
                fragment = DashboardFragment()
            }
            R.id.nav_public_service ->{
                fragment = PublicServicesFragment()
            }
            R.id.nav_ekonomi -> {
                fragment = EkonomiFragment()
            }
//            R.id.nav_account -> fragment = AccountFragment()
        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit()
            return true
        }
        return false
    }
}
