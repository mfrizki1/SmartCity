package id.co.iconpln.smartcity.ui.dashboard.chartfragment

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ValueFormatter

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_anggaran_apbd.*
import java.text.DecimalFormat


class AnggaranAPBDFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anggaran_apbd, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tf: Typeface =
            Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        super.onViewCreated(view, savedInstanceState)

        val data = BarData(xAxisValue(), dataSets())

        graph_anggaran.data = data
        graph_anggaran.setDescription("")
        graph_anggaran.animateXY(500, 500)
        graph_anggaran.invalidate()

        graph_anggaran.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_anggaran.xAxis.textSize = 9f
        graph_anggaran.xAxis.typeface = tf
        graph_anggaran.xAxis.setDrawGridLines(false)
        graph_anggaran.setDrawGridBackground(false)
        graph_anggaran.setDrawBarShadow(false)
        graph_anggaran.isHighlightEnabled = false
        graph_anggaran.setVisibleXRange(7f)
        graph_anggaran.animateXY(500, 500)

        val l = graph_anggaran.legend
        l.isEnabled = false
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_anggaran.axisRight.isEnabled = false

        val yAxis: YAxis = graph_anggaran.getAxis(YAxis.AxisDependency.LEFT)
        yAxis.setStartAtZero(false)
        yAxis.setValueFormatter(MyValueFormatter)
    }

    private fun dataSets(): ArrayList<BarDataSet> {

        val tf: Typeface =
            Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        val total = ArrayList<BarEntry>()
        total.add(BarEntry(600f, 0))
        total.add(BarEntry(500f, 1))
        total.add(BarEntry(650f, 2))
        total.add(BarEntry(700f, 3))

        val realisasi = ArrayList<BarEntry>()
        realisasi.add(BarEntry(827.4f, 0))
        realisasi.add(BarEntry(819.8f, 1))
        realisasi.add(BarEntry(986.8f, 2))
        realisasi.add(BarEntry(1006f, 3))

        val belum = ArrayList<BarEntry>()
        belum.add(BarEntry(-227.4f, 0))
        belum.add(BarEntry(-319.8f, 1))
        belum.add(BarEntry(-336.8f, 2))
        belum.add(BarEntry(-359.4f, 3))

        val barDataSet1 = BarDataSet(total, "Total Anggaran")
        barDataSet1.setColor(Color.rgb(204, 232, 255))
        barDataSet1.valueTextSize = 7f
        barDataSet1.valueTypeface = tf
        barDataSet1.valueFormatter = DataValueFormatter

        val barDataSet2 = BarDataSet(realisasi, "Realisasi Anggaran")
        barDataSet2.setColor(Color.rgb(255, 204, 204))
        barDataSet2.valueTextSize = 7f
        barDataSet2.valueTypeface = tf
        barDataSet2.valueFormatter = DataValueFormatter


        val barDataSet3 = BarDataSet(belum, "Belum Realisasi")
        barDataSet3.setColor(Color.rgb(190, 183, 255))
        barDataSet3.valueTextSize = 7f
        barDataSet3.valueFormatter = DataValueFormatter

        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSet1)
        dataSets.add(barDataSet2)
        dataSets.add(barDataSet3)

        return dataSets
    }

    private fun xAxisValue(): ArrayList<String> {
        val xaxis = ArrayList<String>()
        xaxis.add("Ngraho")
        xaxis.add("Ngambon")
        xaxis.add("Kedungadem")
        xaxis.add("Gondang")

        return xaxis
    }

    object MyValueFormatter : ValueFormatter {
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("###,###,####")
            if (value > 1000) {
                return "RP. " + format.format(value) + " Miliar"
            }
            return "RP. " + format.format(value) + " Juta"
        }

    }

    object DataValueFormatter : ValueFormatter {
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("###,###,##0.0")
            if (value > 1000) {
                return "RP. " + format.format(value) + " Miliar"
            }
            return "RP. " + format.format(value) + " Juta"
        }

    }
}
