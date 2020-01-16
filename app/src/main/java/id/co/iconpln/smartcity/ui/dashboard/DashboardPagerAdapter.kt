package id.co.iconpln.smartcity.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.co.iconpln.smartcity.ui.ekonomi.EkonomiFragment
import id.co.iconpln.smartcity.ui.publicservices.PublicServicesFragment

class DashboardPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                DashboardFragment()
            }
            1->{
                PublicServicesFragment()
            }
            2->EkonomiFragment()
            else->{DashboardFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "DashBoard"
            1 -> "Public Services"
            2 -> "Ekonomi"
            else -> "Akun"
        }
    }

}