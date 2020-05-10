package id.co.iconpln.smartcity.ui.ekonomi.apbd

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
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.github.mikephil.charting.utils.ValueFormatter

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_data_apbd.*
import java.text.DecimalFormat


class DataApbdFragment : Fragment(), OnChartValueSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_apbd, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = BarData(xAxisValue(), dataSets())

        graph_apbd.data= data
        graph_apbd.setDescription("")
        graph_apbd.animateXY(500, 500)
        graph_apbd.invalidate()

        graph_apbd.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_apbd.xAxis.textSize = 9f
        graph_apbd.xAxis.typeface = Typeface.DEFAULT
        graph_apbd.xAxis.setDrawGridLines(false)
        graph_apbd.setDrawGridBackground(false)
        graph_apbd.setDrawBarShadow(false)
        graph_apbd.isHighlightEnabled = false
        graph_apbd.setVisibleXRange(7f)
        graph_apbd.animateXY(500, 500)

        val l = graph_apbd.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_apbd.axisRight.isEnabled = false

        val yAxis : YAxis = graph_apbd.getAxis(YAxis.AxisDependency.LEFT)
        yAxis.setStartAtZero(false)
        yAxis.setValueFormatter(MyValueFormatter)
    }

    private fun dataSets():ArrayList<BarDataSet>{
        val total = ArrayList<BarEntry>()
        total.add(BarEntry(600f, 0))
        total.add(BarEntry(500f,1))
        total.add(BarEntry(650f, 2))
        total.add(BarEntry(700f, 3))

        val realisasi = ArrayList<BarEntry>()
        realisasi.add(BarEntry(827.4f, 0))
        realisasi.add(BarEntry(819.8f,1))
        realisasi.add(BarEntry(986.8f, 2))
        realisasi.add(BarEntry(1006f, 3))

        val belum = ArrayList<BarEntry>()
        belum.add(BarEntry(-227.4f, 0))
        belum.add(BarEntry(-319.8f,1))
        belum.add(BarEntry(-336.8f, 2))
        belum.add(BarEntry(-359.4f, 3))

        val barDataSet1 = BarDataSet(total, "Total Anggaran")
        barDataSet1.setColor(Color.rgb(204, 232, 255))
        barDataSet1.valueTextSize = 7f
        barDataSet1.valueFormatter = DataValueFormatter

        val barDataSet2 = BarDataSet(realisasi, "Realisasi Anggaran")
        barDataSet2.setColor(Color.rgb(255, 204, 204))
        barDataSet2.valueTextSize = 7f
        barDataSet2.valueFormatter = DataValueFormatter


        val barDataSet3 = BarDataSet(belum, "Belum Realisasi")
        barDataSet3.setColor(Color.rgb(190, 183, 255))
        barDataSet3.valueTextSize = 7f
        barDataSet3.valueFormatter = DataValueFormatter

        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSet1)
        dataSets.add(barDataSet2)
        dataSets.add(barDataSet3)

        return  dataSets
    }

    private fun xAxisValue(): ArrayList<String>{
        val xaxis = ArrayList<String>()
        xaxis.add("Ngraho")
        xaxis.add("Ngambon")
        xaxis.add("Kedungadem")
        xaxis.add("Gondang")

        return xaxis
    }

    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    object MyValueFormatter : ValueFormatter{
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("###,###,####")
            if (value > 1000){
                return "RP. "+format.format(value)+ " Miliar"
            }
            return "RP. "+format.format(value)+ " Juta"
        }

    }

    object DataValueFormatter: ValueFormatter{
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("###,###,##0.0")
            if (value > 1000){
                return "RP. "+format.format(value)+ " Miliar"
            }
            return "RP. "+format.format(value)+ " Juta"
        }

    }
}
