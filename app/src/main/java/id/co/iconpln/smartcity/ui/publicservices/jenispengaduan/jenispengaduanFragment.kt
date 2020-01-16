package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import android.content.Context
import android.graphics.Color
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
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_jenispengaduan.*

class jenispengaduanFragment : Fragment(), OnChartValueSelectedListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenispengaduan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jenisPengaduan()
    }

    private fun jenisPengaduan() {
        piePengaduan.setUsePercentValues(true)
        val xvalues = ArrayList<PieEntry>()
        xvalues.add(PieEntry(35f, "Biasa"))
        xvalues.add(PieEntry(12f, "Sedang"))
        xvalues.add(PieEntry(18f, "Lumayan"))
        xvalues.add(PieEntry(35f, "Bahaya"))
        val dataSet = PieDataSet(xvalues, "Jenis Pengaduan")
        dataSet.setColors(Color.GREEN, Color.CYAN, Color.YELLOW, Color.MAGENTA)
        dataSet.sliceSpace = 2f
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())

        piePengaduan.data = data
        piePengaduan.description.text =""
        piePengaduan.invalidate()


//        piePengaduan.setOnChartValueSelectedListener(this)
//        chartDetails(piePengaduan, Typeface.SANS_SERIF)
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
*/
    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {

    }

}
