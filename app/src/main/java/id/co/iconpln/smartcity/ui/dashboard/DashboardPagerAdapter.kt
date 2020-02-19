package id.co.iconpln.smartcity.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.co.iconpln.smartcity.ui.dashboard.datakesehatan.DataKesehatanFragment
import id.co.iconpln.smartcity.ui.dashboard.jumlahpengaduan.JumlahPengaduanFragment
import id.co.iconpln.smartcity.ui.dashboard.pendapatanpajak.PendapatanPajakFragment
import id.co.iconpln.smartcity.ui.dashboard.penyerapanapbd.PenyerapanAPBDFragment
import id.co.iconpln.smartcity.ui.ekonomi.EkonomiFragment
import id.co.iconpln.smartcity.ui.publicservices.PublicServicesFragment

class DashboardPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm){


    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                JumlahPengaduanFragment()
            }
            1->{
                PenyerapanAPBDFragment()
            }
            2->{
                PendapatanPajakFragment()
            }
            else->{DataKesehatanFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Jumlah Pengaduan"
            1 -> "Penyerapan Anggaran APBD"
            2 -> "Pendapatan Pajak"
            else -> "Data Kesehatan"
        }
    }


}