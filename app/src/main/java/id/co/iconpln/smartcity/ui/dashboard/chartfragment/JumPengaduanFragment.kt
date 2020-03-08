package id.co.iconpln.smartcity.ui.dashboard.chartfragment

import android.content.Context
import android.content.res.AssetManager
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
import com.github.mikephil.charting.utils.LargeValueFormatter

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_jum_pengaduan.*


class JumPengaduanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jum_pengaduan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tf : Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        val data = BarData(xAxisValue(), dataSets())

        graph_jumPengaduan.data = data

        graph_jumPengaduan.setDescription("")
        graph_jumPengaduan.animateXY(500, 500)
        graph_jumPengaduan.invalidate()

        graph_jumPengaduan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_jumPengaduan.xAxis.textSize = 9f
        graph_jumPengaduan.xAxis.typeface = tf
        graph_jumPengaduan.xAxis.setDrawGridLines(false)
        graph_jumPengaduan.setDrawGridBackground(false)
        graph_jumPengaduan.setDrawBarShadow(false)
        graph_jumPengaduan.isHighlightEnabled = false
        graph_jumPengaduan.setVisibleXRange(7f)
        graph_jumPengaduan.animateXY(500, 500)

        graph_jumPengaduan.legend.isEnabled = false

        graph_jumPengaduan.axisRight.isEnabled = false

        val yAxis: YAxis = graph_jumPengaduan.getAxis(YAxis.AxisDependency.LEFT)

    }

    private fun xAxisValue(): ArrayList<String> {
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

    private fun dataSets(): ArrayList<BarDataSet> {
        val dataBar = ArrayList<BarEntry>()
        dataBar.add(BarEntry(10f, 0))
        dataBar.add(BarEntry(15f, 1))
        dataBar.add(BarEntry(13f, 2))
        dataBar.add(BarEntry(34f, 3))
        dataBar.add(BarEntry(49f, 4))
        dataBar.add(BarEntry(12f, 5))
        dataBar.add(BarEntry(96f, 6))
        dataBar.add(BarEntry(11f, 7))
        dataBar.add(BarEntry(104f, 8))
        dataBar.add(BarEntry(53f, 9))
        dataBar.add(BarEntry(53f, 10))
        dataBar.add(BarEntry(0f, 11))

        val tf : Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        val barDataSet1 = BarDataSet(dataBar, "")
        barDataSet1.setColor(Color.rgb(204, 232, 255))
        barDataSet1.valueTextSize = 8f
        barDataSet1.valueTypeface = tf
        barDataSet1.valueFormatter = LargeValueFormatter()


        val dataSetsa = ArrayList<BarDataSet>()
        dataSetsa.add(barDataSet1)

        return dataSetsa

    }
}