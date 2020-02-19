package id.co.iconpln.smartcity.ui.publicservices

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import com.github.mikephil.charting.utils.LargeValueFormatter
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ViewPagerAdapter
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.datapengaduanFragment
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.jenispengaduanFragment
import kotlinx.android.synthetic.main.fragment_publicservices.*

class PublicServicesFragment : Fragment(), OnChartValueSelectedListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_publicservices, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTab(viewpagerPengaduan)

        val dataPerijinan = BarData(xAxisValuePerijinan(), dataSetsPerijinan())
        graphPerijinan(dataPerijinan)

        val dataDemograpi = BarData(xAxisValueDemograpi(), dataSetsDemograpi())
        graphDemograpi(dataDemograpi)



    }

    private fun setupTab(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(datapengaduanFragment(), "Data Pengaduan")
        adapter.populateFragment(jenispengaduanFragment(), "Jenis Pengaduan")
        viewPager.adapter = adapter
        tabpengaduan.setupWithViewPager(viewPager)
    }

    private fun graphPerijinan(data: BarData){
        graph_perijinan.data= data
        graph_perijinan.setDescription("")
        graph_perijinan.animateXY(500, 500)
        graph_perijinan.invalidate()

        graph_perijinan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_perijinan.xAxis.textSize = 9f
        graph_perijinan.xAxis.typeface = Typeface.DEFAULT
        graph_perijinan.xAxis.setDrawGridLines(false)
        graph_perijinan.setDrawGridBackground(false)
        graph_perijinan.setDrawBarShadow(false)
        graph_perijinan.isHighlightEnabled = false
        graph_perijinan.setVisibleXRange(7f)

        graph_perijinan.legend.isEnabled = false

        graph_perijinan.axisRight.isEnabled = false
    }
    private fun dataSetsPerijinan():ArrayList<BarDataSet>{
        val bar1 = ArrayList<BarEntry>()
        bar1.add(BarEntry(10f, 0))
        bar1.add(BarEntry(8f,1))
        bar1.add(BarEntry(45f, 2))
        bar1.add(BarEntry(15f, 3))
        bar1.add(BarEntry(25f, 4))
        bar1.add(BarEntry(75f, 5))
        bar1.add(BarEntry(110f, 6))
        bar1.add(BarEntry(21f, 7))
        bar1.add(BarEntry(24f, 8))
        bar1.add(BarEntry(30f, 9))
        bar1.add(BarEntry(11f, 10))
        bar1.add(BarEntry(14f, 11))

        val barDataSet1 = BarDataSet(bar1, "")
        barDataSet1.setColor(Color.rgb(0, 155, 50))
        barDataSet1.valueTextSize = 6f
        barDataSet1.valueFormatter = LargeValueFormatter()


        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSet1)

        return  dataSets
    }
    private fun xAxisValuePerijinan(): ArrayList<String>{
        val xaxis = ArrayList<String>()
        xaxis.add("JAN")
        xaxis.add("FEB")
        xaxis.add("MAR")
        xaxis.add("APR")
        xaxis.add("MAY")
        xaxis.add("JUN")
        xaxis.add("JUL")
        xaxis.add("AGS")
        xaxis.add("SEP")
        xaxis.add("OKT")
        xaxis.add("NOV")
        xaxis.add("DES")

        return xaxis
    }

    private fun graphDemograpi(data: BarData){
        graph_demograpi.data = data
        graph_demograpi.setDescription("")
        graph_demograpi.animateXY(500, 500)
        graph_demograpi.invalidate()

        graph_demograpi.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_demograpi.xAxis.textSize = 9f
        graph_demograpi.xAxis.typeface = Typeface.DEFAULT
        graph_demograpi.xAxis.setDrawGridLines(false)
        graph_demograpi.setDrawGridBackground(false)
        graph_demograpi.setDrawBarShadow(false)
        graph_demograpi.isHighlightEnabled = false
        graph_demograpi.setVisibleXRange(7f)

        graph_demograpi.axisRight.isEnabled = false
        graph_demograpi.axisLeft.valueFormatter = LargeValueFormatter()

        val l = graph_demograpi.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

    }
    private fun dataSetsDemograpi(): ArrayList<BarDataSet>{
        val barLaki = ArrayList<BarEntry>()
        barLaki.add(BarEntry(10f, 0))
        barLaki.add(BarEntry(8f,1))
        barLaki.add(BarEntry(45f, 2))
        barLaki.add(BarEntry(15f, 3))
        barLaki.add(BarEntry(25f, 4))

        val barCewe = ArrayList<BarEntry>()
        barCewe.add(BarEntry(14f, 0))
        barCewe.add(BarEntry(11f, 1))
        barCewe.add(BarEntry(30f, 2))
        barCewe.add(BarEntry(24f, 3))
        barCewe.add(BarEntry(21f, 4))

        val barDataSetCowo = BarDataSet(barLaki, "Laki-Laki")
        barDataSetCowo.setColor(Color.rgb(51, 153, 255))
        barDataSetCowo.valueTextSize = 6f
        barDataSetCowo.valueFormatter = LargeValueFormatter()

        val barDataSetCewe = BarDataSet(barCewe, "Perempuan")
        barDataSetCewe.setColor(Color.rgb(255, 51, 51))
        barDataSetCewe.valueTextSize = 6f
        barDataSetCewe.valueFormatter = LargeValueFormatter()

        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSetCewe)
        dataSets.add(barDataSetCowo)

        return  dataSets
    }
    private fun xAxisValueDemograpi(): ArrayList<String>{
        val xaxis = ArrayList<String>()
        xaxis.add("5-11")
        xaxis.add("11-17")
        xaxis.add("18-22")
        xaxis.add("23-30")
        xaxis.add("31-40")

        return xaxis
    }

    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {

    }

}

