package id.co.iconpln.smartcity.ui.dashboard.chartfragment

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_pen_pajak.*


class PenPajakFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pen_pajak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = LineData(xVal(), dataValues())

        line_pajak.data = data
        line_pajak.legend.isEnabled = false
        line_pajak.setPinchZoom(true)
        line_pajak.xAxis.enableGridDashedLine(5f, 5f, 0f)
        line_pajak.axisRight.enableGridDashedLine(5f, 5f,0f)
        line_pajak.axisLeft.enableGridDashedLine(5f, 5f,0f)
        line_pajak.setVisibleXRange(8f)
        line_pajak.xAxis.position = XAxis.XAxisPosition.BOTTOM
        line_pajak.setDrawGridBackground(false)
        line_pajak.setDescription("")

    }

    fun dataValues() : ArrayList<LineDataSet>{
        val value = ArrayList<Entry>()
        value.add(Entry(30f,0, "0"))
        value.add(Entry(20f,1, "1"))
        value.add(Entry(10f,2, "2"))
        value.add(Entry(40f,3, "3"))
        value.add(Entry(50f,4, "4"))
        value.add(Entry(3f,5, "5"))
        value.add(Entry(10f,6, "6"))
        value.add(Entry(15f,7, "7"))
        value.add(Entry(35f,8, "8"))

        val set1 = LineDataSet(value, "")
        set1.setColor(Color.rgb(66, 165, 245))
        set1.setCircleColor(Color.rgb(66, 165, 245))
        set1.lineWidth = 1f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 4f
        set1.setDrawFilled(true)

        val dataSet = ArrayList<LineDataSet>()
        dataSet.add(set1)


        return dataSet
    }

    fun xVal() : ArrayList<String>{
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

}
