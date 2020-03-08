package id.co.iconpln.smartcity.ui.dashboard

import android.content.Context
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.base.BaseFragment
import id.co.iconpln.smartcity.widget.SwipeLockableViewPager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import id.co.iconpln.smartcity.util.ViewPagerAdapter
import id.co.iconpln.smartcity.ui.dashboard.chartfragment.JumPengaduanFragment
import id.co.iconpln.smartcity.ui.dashboard.chartfragment.AnggaranAPBDFragment
import id.co.iconpln.smartcity.ui.dashboard.chartfragment.PenPajakFragment
import id.co.iconpln.smartcity.ui.dashboard.chartfragment.DataKesehatanFragment


class DashboardFragment : BaseFragment() {

    private lateinit var dashboardPagerAdapter: DashboardPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupWithTab(viewpagerDash)

    }

    override fun onAuthFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setupWithTab(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(JumPengaduanFragment(), "Jumlah Pengaduan")
        adapter.populateFragment(AnggaranAPBDFragment(), "Penyerapan Anggaran APBD")
        adapter.populateFragment(PenPajakFragment(), "Pendapatan Pajak")
        adapter.populateFragment(DataKesehatanFragment(), "Dana Kesehatan")
        viewPager.adapter = adapter
        tabDashboard.setupWithViewPager(viewPager)
    }


}
