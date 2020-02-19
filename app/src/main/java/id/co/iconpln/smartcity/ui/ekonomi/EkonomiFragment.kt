package id.co.iconpln.smartcity.ui.ekonomi

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ViewPagerAdapter
import id.co.iconpln.smartcity.ui.ekonomi.apbd.DataApbdFragment
import id.co.iconpln.smartcity.ui.ekonomi.apbd.TotalApbdFragment
import id.co.iconpln.smartcity.ui.ekonomi.pendapatandesa.DataPendapatanDesaFragment
import id.co.iconpln.smartcity.ui.ekonomi.pendapatandesa.TotalPendapatanDesaFragment
import id.co.iconpln.smartcity.ui.ekonomi.pembiayaandesa.DataPembiayaanDesaFragment
import id.co.iconpln.smartcity.ui.ekonomi.pembiayaandesa.TotalPembiayaanDesaFragment
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import kotlinx.android.synthetic.main.fragment_ekonomi.*

class EkonomiFragment : Fragment(), OnChartValueSelectedListener{


    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?)= inflater.inflate(R.layout.fragment_ekonomi, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabApbd(viewpagerApbd)
        setupTabPendapatanDesa(viewpagerPendapatanDesa)
        setupTabPembiayaanDesa(viewpagerPembiayaanDesa)

    }


    private fun setupTabApbd(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(DataApbdFragment(), "Data Apbd")
        adapter.populateFragment(TotalApbdFragment(), "Total Belanja Desa")
        viewPager.adapter = adapter
        tabApbd.setupWithViewPager(viewPager)
    }
    private fun setupTabPendapatanDesa(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(DataPendapatanDesaFragment(), "Data Pendapatan Desa")
        adapter.populateFragment(TotalPendapatanDesaFragment(), "Total Pendapatan Desa")
        viewPager.adapter = adapter
        tabPendapatanDesa.setupWithViewPager(viewPager)
    }
    private fun setupTabPembiayaanDesa(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(DataPembiayaanDesaFragment(), "Data Pembiayaan Desa")
        adapter.populateFragment(TotalPembiayaanDesaFragment(), "Total Pembiayaan Desa")
        viewPager.adapter = adapter
        tabPembiayaanDesa.setupWithViewPager(viewPager)
    }



    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}