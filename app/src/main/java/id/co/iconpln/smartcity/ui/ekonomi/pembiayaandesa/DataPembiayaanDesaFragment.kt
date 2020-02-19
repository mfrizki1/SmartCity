package id.co.iconpln.smartcity.ui.ekonomi.pembiayaandesa

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
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.github.mikephil.charting.utils.ValueFormatter

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_data_pembiayaan_desa.*
import java.text.DecimalFormat


class DataPembiayaanDesaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_pembiayaan_desa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val data = BarData(xAxisValue(), dataSets())

        graph_databiayadesa.data = data
        graph_databiayadesa.setDescription("")
        graph_databiayadesa.animateXY(500, 500)
        graph_databiayadesa.invalidate()

        graph_databiayadesa.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_databiayadesa.xAxis.textSize = 9f
        graph_databiayadesa.xAxis.typeface = Typeface.DEFAULT
        graph_databiayadesa.xAxis.setDrawGridLines(false)
        graph_databiayadesa.setDrawGridBackground(false)
        graph_databiayadesa.setDrawBarShadow(false)
        graph_databiayadesa.isHighlightEnabled = false
        graph_databiayadesa.setVisibleXRange(7f)

        graph_databiayadesa.axisLeft.valueFormatter = MyValueFormatter

        graph_databiayadesa.axisRight.isEnabled = false

        val l = graph_databiayadesa.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER


    }

    private fun dataSets():ArrayList<BarDataSet>{
        val gajidesa = ArrayList<BarEntry>()
        gajidesa.add(BarEntry(10f, 0))
        gajidesa.add(BarEntry(10f,1))
        gajidesa.add(BarEntry(10f, 2))
        gajidesa.add(BarEntry(10f, 3))
        gajidesa.add(BarEntry(10f, 4))
        gajidesa.add(BarEntry(10f, 5))
        gajidesa.add(BarEntry(10f, 6))
        gajidesa.add(BarEntry(10f, 7))
        gajidesa.add(BarEntry(10f, 8))
        gajidesa.add(BarEntry(10f, 9))
        gajidesa.add(BarEntry(10f, 10))
        gajidesa.add(BarEntry(10f, 11))

        val infrastruktur = ArrayList<BarEntry>()
        infrastruktur.add(BarEntry(20f, 0))
        infrastruktur.add(BarEntry(20f,1))
        infrastruktur.add(BarEntry(20f, 2))
        infrastruktur.add(BarEntry(20f, 3))
        infrastruktur.add(BarEntry(20f, 4))
        infrastruktur.add(BarEntry(20f, 5))
        infrastruktur.add(BarEntry(20f, 6))
        infrastruktur.add(BarEntry(20f, 7))
        infrastruktur.add(BarEntry(20f, 8))
        infrastruktur.add(BarEntry(20f, 9))
        infrastruktur.add(BarEntry(20f, 10))
        infrastruktur.add(BarEntry(20f, 11))

        val rapker = ArrayList<BarEntry>()
        rapker.add(BarEntry(30f, 0))
        rapker.add(BarEntry(30f,1))
        rapker.add(BarEntry(30f, 2))
        rapker.add(BarEntry(30f, 3))
        rapker.add(BarEntry(30f, 4))
        rapker.add(BarEntry(30f, 5))
        rapker.add(BarEntry(30f, 6))
        rapker.add(BarEntry(30f, 7))
        rapker.add(BarEntry(30f, 8))
        rapker.add(BarEntry(30f, 9))
        rapker.add(BarEntry(30f, 10))
        rapker.add(BarEntry(30f, 11))

        val barDataSet1 = BarDataSet(gajidesa, "Gaji Perangkat Desa")
        barDataSet1.setColor(Color.rgb(0, 155, 0))
        barDataSet1.valueTextSize = 7f
        barDataSet1.valueFormatter = DataValueFormatter

        val barDataSet2 = BarDataSet(infrastruktur, "Pemeliharaan Infrasturktur")
        barDataSet2.setColor(Color.rgb(0, 0, 155))
        barDataSet2.valueTextSize = 7f
        barDataSet2.valueFormatter = DataValueFormatter


        val barDataSet3 = BarDataSet(rapker, "Rapat Kerja")
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
