package id.co.iconpln.smartcity.ui.ekonomi.pendapatandesa

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.github.mikephil.charting.utils.ValueFormatter

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_data_pendapatan_desa.*
import java.text.DecimalFormat


class DataPendapatanDesaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_pendapatan_desa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val data = BarData(xAxisValue(), dataSets())

        graph_datapendapatandesa.data = data
        graph_datapendapatandesa.setDescription("")
        graph_datapendapatandesa.animateXY(500, 500)
        graph_datapendapatandesa.invalidate()

        graph_datapendapatandesa.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_datapendapatandesa.xAxis.textSize = 9f
        graph_datapendapatandesa.xAxis.typeface = Typeface.DEFAULT
        graph_datapendapatandesa.xAxis.setDrawGridLines(false)
        graph_datapendapatandesa.setDrawGridBackground(false)
        graph_datapendapatandesa.setDrawBarShadow(false)
        graph_datapendapatandesa.isHighlightEnabled = false
        graph_datapendapatandesa.setVisibleXRange(7f)

        graph_datapendapatandesa.axisLeft.valueFormatter = MyValueFormatter

        graph_datapendapatandesa.axisRight.isEnabled = false

        val l = graph_datapendapatandesa.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER



    }

    private fun dataSets():ArrayList<BarDataSet>{
        val bumdes = ArrayList<BarEntry>()
        bumdes.add(BarEntry(10f, 0))
        bumdes.add(BarEntry(10f,1))
        bumdes.add(BarEntry(10f, 2))
        bumdes.add(BarEntry(10f, 3))
        bumdes.add(BarEntry(10f, 4))
        bumdes.add(BarEntry(10f, 5))
        bumdes.add(BarEntry(10f, 6))
        bumdes.add(BarEntry(10f, 7))
        bumdes.add(BarEntry(10f, 8))
        bumdes.add(BarEntry(10f, 9))
        bumdes.add(BarEntry(10f, 10))
        bumdes.add(BarEntry(10f, 11))

        val danadesa = ArrayList<BarEntry>()
        danadesa.add(BarEntry(20f, 0))
        danadesa.add(BarEntry(20f,1))
        danadesa.add(BarEntry(20f, 2))
        danadesa.add(BarEntry(20f, 3))
        danadesa.add(BarEntry(20f, 4))
        danadesa.add(BarEntry(20f, 5))
        danadesa.add(BarEntry(20f, 6))
        danadesa.add(BarEntry(20f, 7))
        danadesa.add(BarEntry(20f, 8))
        danadesa.add(BarEntry(20f, 9))
        danadesa.add(BarEntry(20f, 10))
        danadesa.add(BarEntry(20f, 11))

        val swadaya = ArrayList<BarEntry>()
        swadaya.add(BarEntry(30f, 0))
        swadaya.add(BarEntry(30f,1))
        swadaya.add(BarEntry(30f, 2))
        swadaya.add(BarEntry(30f, 3))
        swadaya.add(BarEntry(30f, 4))
        swadaya.add(BarEntry(30f, 5))
        swadaya.add(BarEntry(30f, 6))
        swadaya.add(BarEntry(30f, 7))
        swadaya.add(BarEntry(30f, 8))
        swadaya.add(BarEntry(30f, 9))
        swadaya.add(BarEntry(30f, 10))
        swadaya.add(BarEntry(30f, 11))

        val barDataSet1 = BarDataSet(bumdes, "BUMDes")
        barDataSet1.setColor(Color.rgb(0, 155, 0))
        barDataSet1.valueTextSize = 7f
        barDataSet1.valueFormatter = DataValueFormatter

        val barDataSet2 = BarDataSet(danadesa, "Dana Desa")
        barDataSet2.setColor(Color.rgb(0, 0, 155))
        barDataSet2.valueTextSize = 7f
        barDataSet2.valueFormatter = DataValueFormatter


        val barDataSet3 = BarDataSet(swadaya, "Swadaya")
        barDataSet3.setColor(Color.rgb(155, 0, 0))
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
