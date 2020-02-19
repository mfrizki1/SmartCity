package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import android.content.Context
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.*

import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ColorTempl
import kotlinx.android.synthetic.main.fragment_jenispengaduan.*
import java.text.DecimalFormat

class jenispengaduanFragment : Fragment(), OnChartValueSelectedListener {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenispengaduan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = ArrayList<Entry>()
        value.add(Entry(110f, 0))
        value.add(Entry(60f, 1))
        value.add(Entry(80f, 2))
        value.add(Entry(158f, 3))
        value.add(Entry(48f, 4))
        value.add(Entry(91f, 5))

        val dataSet = PieDataSet(value, "")
        dataSet.valueTextSize = 10f
        dataSet.setColors(ColorTempl.custom)
        dataSet.valueFormatter = PercentFormatter()
        dataSet.valueTextColor = resources.getColor(R.color.ghost_white)


        val jenis = ArrayList<String>()
        jenis.add("Lalu Lintas")
        jenis.add("Infrastruktur")
        jenis.add("Kebersihan")
        jenis.add("Pelayanan Publik")
        jenis.add("Transportasi")
        jenis.add("Umum")

        val data = PieData(jenis, dataSet)
        piePengaduan.data = data

        piePengaduan.isDrawHoleEnabled = false
        piePengaduan.isRotationEnabled = true
        piePengaduan.setDescription("")
        piePengaduan.setDrawSliceText(true)
        piePengaduan.setDrawCenterText(true)
        piePengaduan.setDrawMarkerViews(true)
        piePengaduan.setUsePercentValues(true)
        piePengaduan.animateXY(500, 500)


        val l = piePengaduan.legend
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER
        l.form = Legend.LegendForm.CIRCLE
        l.direction = Legend.LegendDirection.LEFT_TO_RIGHT
        l.textSize = 8f
        l.formToTextSpace = 2f
        l.stackSpace = 2f


    }

    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    object MyValueFormatter : ValueFormatter {
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("#####")
            return format.format(value)
        }

    }

}

/* private fun chartDetails(piePengaduan: PieChart, sansSerif: Typeface?) {
     piePengaduan.description.isEnabled = true
     piePengaduan.centerText = ""
     piePengaduan.setCenterTextSize(10f)
     piePengaduan.setCenterTextTypeface(sansSerif)
     val l = piePengaduan.legend
     piePengaduan.legend.isWordWrapEnabled = true
     piePengaduan.legend.isEnabled = false
     l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
     l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
     l.formSize = 20f
     l.formToTextSpace = 5f
     l.textSize = 12f
     l.orientation = Legend.LegendOrientation.HORIZONTAL
     l.isWordWrapEnabled = true
     l.setDrawInside(false)
     piePengaduan.setTouchEnabled(false)
     piePengaduan.setDrawEntryLabels(false)
     piePengaduan.legend.isWordWrapEnabled = true
     piePengaduan.setExtraOffsets(20f, 0f, 20f, 0f)
     piePengaduan.setUsePercentValues(true)
     piePengaduan.setDrawCenterText(false)
     piePengaduan.description.isEnabled = true
     piePengaduan.isRotationEnabled = false

 }
}*/

