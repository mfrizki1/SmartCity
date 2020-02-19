package id.co.iconpln.smartcity.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(), OnChartValueSelectedListener{
    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTab()
    }

    private fun setupTab(){
        val adapter = DashboardPagerAdapter(childFragmentManager)
        viewpagerDashboard.adapter = adapter
        tablayout.setupWithViewPager(viewpagerDashboard)
    }

    override fun onNothingSelected(){
    }
}