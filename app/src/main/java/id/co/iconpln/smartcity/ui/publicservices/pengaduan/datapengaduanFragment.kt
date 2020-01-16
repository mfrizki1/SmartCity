package id.co.iconpln.smartcity.ui.publicservices.pengaduan

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import id.co.iconpln.smartcity.R


class datapengaduanFragment : Fragment(), OnChartValueSelectedListener {

    lateinit var barChartView: BarChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_datapengaduan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pengaduan()
    }

    private fun pengaduan() {
        barChartView = view!!.findViewById(R.id.graph_pengaduan)

        val barWidth: Float
        val barSpace: Float
        val groupSpace: Float
        val groupCount = 12

        barWidth = 0.18f //gemuk/ kurusnya bar
        barSpace = 0.07f // perbar
        groupSpace = 0.25f // antar bulan

        var xAxisValues = ArrayList<String>()
        xAxisValues.add("Jan")
        xAxisValues.add("Feb")
        xAxisValues.add("Mar")
        xAxisValues.add("Apr")
        xAxisValues.add("May")
        xAxisValues.add("June")
        xAxisValues.add("Jul")
        xAxisValues.add("Aug")
        xAxisValues.add("Sep")
        xAxisValues.add("Oct")
        xAxisValues.add("Nov")
        xAxisValues.add("Dec")

        var yValueGroup1 = ArrayList<BarEntry>()
        var yValueGroup2 = ArrayList<BarEntry>()
        var yValueGroup3 = ArrayList<BarEntry>()

        // draw the graph
        var barDataSet1: BarDataSet
        var barDataSet2: BarDataSet
        var barDataSet3: BarDataSet


        yValueGroup1.add(BarEntry(1f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(1f, floatArrayOf(2.toFloat(), 7.toFloat())))
        yValueGroup3.add(BarEntry(1f, floatArrayOf(24.toFloat(), 13.toFloat())))


        yValueGroup1.add(BarEntry(2f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(2f, floatArrayOf(4.toFloat(), 15.toFloat())))
        yValueGroup3.add(BarEntry(2f, floatArrayOf(3.toFloat(), 1.toFloat())))

        yValueGroup1.add(BarEntry(3f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(3f, floatArrayOf(4.toFloat(), 15.toFloat())))
        yValueGroup3.add(BarEntry(3f, floatArrayOf(4.toFloat(), 10.toFloat())))

        yValueGroup1.add(BarEntry(4f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(4f, floatArrayOf(4.toFloat(), 15.toFloat())))
        yValueGroup3.add(BarEntry(4f, floatArrayOf(14.toFloat(), 20.toFloat())))


        yValueGroup1.add(BarEntry(5f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(5f, floatArrayOf(10.toFloat(), 6.toFloat())))
        yValueGroup3.add(BarEntry(5f, floatArrayOf(6.toFloat(), 3.toFloat())))

        yValueGroup1.add(BarEntry(6f, floatArrayOf(11.toFloat(), 1.toFloat())))
        yValueGroup2.add(BarEntry(6f, floatArrayOf(12.toFloat(), 2.toFloat())))
        yValueGroup3.add(BarEntry(6f, floatArrayOf(8.toFloat(), 20.toFloat())))


        yValueGroup1.add(BarEntry(7f, floatArrayOf(11.toFloat(), 7.toFloat())))
        yValueGroup2.add(BarEntry(7f, floatArrayOf(12.toFloat(), 12.toFloat())))
        yValueGroup3.add(BarEntry(7f, floatArrayOf(4.toFloat(), 14.toFloat())))


        yValueGroup1.add(BarEntry(8f, floatArrayOf(11.toFloat(), 9.toFloat())))
        yValueGroup2.add(BarEntry(8f, floatArrayOf(12.toFloat(), 8.toFloat())))
        yValueGroup3.add(BarEntry(8f, floatArrayOf(6.toFloat(), 8.toFloat())))



        yValueGroup1.add(BarEntry(9f, floatArrayOf(11.toFloat(), 13.toFloat())))
        yValueGroup2.add(BarEntry(9f, floatArrayOf(12.toFloat(), 12.toFloat())))
        yValueGroup3.add(BarEntry(9f, floatArrayOf(19.toFloat(), 20.toFloat())))

        yValueGroup1.add(BarEntry(10f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(10f, floatArrayOf(12.toFloat(), 7.toFloat())))
        yValueGroup3.add(BarEntry(10f, floatArrayOf(17.toFloat(), 7.toFloat())))

        yValueGroup1.add(BarEntry(11f, floatArrayOf(11.toFloat(), 6.toFloat())))
        yValueGroup2.add(BarEntry(11f, floatArrayOf(12.toFloat(), 5.toFloat())))
        yValueGroup3.add(BarEntry(11f, floatArrayOf(22.toFloat(), 12.toFloat())))

        yValueGroup1.add(BarEntry(12f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(12f, floatArrayOf(12.toFloat(), 3.toFloat())))
        yValueGroup3.add(BarEntry(12f, floatArrayOf(20.toFloat(), 10.toFloat())))


        barDataSet1 = BarDataSet(yValueGroup1, "")
        barDataSet1.setColors(Color.BLUE)
        barDataSet1.label = "Diproses"
        barDataSet1.setDrawIcons(false)
        barDataSet1.setDrawValues(false)



        barDataSet2 = BarDataSet(yValueGroup2, "")
        barDataSet2.label = "Selesai"
        barDataSet2.setColors(Color.YELLOW)
        barDataSet2.setDrawIcons(false)
        barDataSet2.setDrawValues(false)

        barDataSet3 = BarDataSet(yValueGroup3, "")
        barDataSet3.setColors(Color.RED)
        barDataSet3.label = "Belum Diproses"
        barDataSet3.setDrawIcons(false)
        barDataSet3.setDrawValues(false)

        var barData = BarData(barDataSet1, barDataSet2, barDataSet3)

        barChartView.description.isEnabled = false
        barChartView.description.textSize = 0f
        barData.setValueFormatter(LargeValueFormatter())
        barChartView.setData(barData)
        barChartView.getBarData().setBarWidth(barWidth)
        barChartView.getXAxis().setAxisMinimum(0f)
        barChartView.getXAxis().setAxisMaximum(12f)
        barChartView.groupBars(0f, groupSpace, barSpace)
        //   barChartView.setFitBars(true)
        barChartView.getData().setHighlightEnabled(false)
        barChartView.invalidate()

        // set bar label
        var legend = barChartView.legend
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL)
        legend.setDrawInside(false)

        var legenedEntries = arrayListOf<LegendEntry>()

        legenedEntries.add(LegendEntry("Diproses", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.BLUE))
        legenedEntries.add(LegendEntry("Selesai", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.YELLOW))
        legenedEntries.add(LegendEntry("Belum Diproses", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.RED))

        legend.setCustom(legenedEntries)

        legend.setYOffset(10f)
        legend.setXOffset(3f)
        legend.setYEntrySpace(0f)
        legend.setTextSize(5f)

        val xAxis = barChartView.getXAxis()
        xAxis.setGranularity(1f)
        xAxis.setGranularityEnabled(true)
        xAxis.setCenterAxisLabels(true)
        xAxis.setDrawGridLines(false)
        xAxis.textSize = 9f

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValues))

        xAxis.setLabelCount(12)
        xAxis.mAxisMaximum = 12f
        xAxis.setCenterAxisLabels(true)
        xAxis.setAvoidFirstLastClipping(true)
        xAxis.spaceMin = 4f
        xAxis.spaceMax = 4f

        barChartView.setVisibleXRangeMaximum(12f)
        barChartView.setVisibleXRangeMinimum(12f)
        barChartView.setDragEnabled(true)

        //Y-axis
        barChartView.getAxisRight().setEnabled(false)
        barChartView.setScaleEnabled(true)

        val leftAxis = barChartView.getAxisLeft()
        leftAxis.setValueFormatter(LargeValueFormatter())
        leftAxis.setDrawGridLines(false)
        leftAxis.setSpaceTop(1f)
        leftAxis.setAxisMinimum(0f)


        barChartView.data = barData
        barChartView.setVisibleXRange(1f, 12f)

    }

    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}