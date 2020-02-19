package id.co.iconpln.smartcity.ui.publicservices.pengaduan

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_datapengaduan.*


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

        val data = BarData(xAxisValue(), dataSets())

        graph_pengaduan.data= data
        graph_pengaduan.setDescription("")
        graph_pengaduan.animateXY(500, 500)
        graph_pengaduan.invalidate()

        graph_pengaduan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_pengaduan.xAxis.textSize = 9f
        graph_pengaduan.xAxis.typeface = Typeface.DEFAULT
        graph_pengaduan.xAxis.setDrawGridLines(false)
        graph_pengaduan.setDrawGridBackground(false)
        graph_pengaduan.setDrawBarShadow(false)
        graph_pengaduan.isHighlightEnabled = false

        val l = graph_pengaduan.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_pengaduan.axisRight.isEnabled = false
    }


    private fun dataSets():ArrayList<BarDataSet>{
        val selesai = ArrayList<BarEntry>()
        selesai.add(BarEntry(10f, 0))
        selesai.add(BarEntry(10f,1))
        selesai.add(BarEntry(10f, 2))
        selesai.add(BarEntry(10f, 3))
        selesai.add(BarEntry(10f, 4))
        selesai.add(BarEntry(10f, 5))
        selesai.add(BarEntry(10f, 6))
        selesai.add(BarEntry(10f, 7))
        selesai.add(BarEntry(10f, 8))
        selesai.add(BarEntry(10f, 9))
        selesai.add(BarEntry(10f, 10))
        selesai.add(BarEntry(10f, 11))

        val proses = ArrayList<BarEntry>()
        proses.add(BarEntry(20f, 0))
        proses.add(BarEntry(20f,1))
        proses.add(BarEntry(20f, 2))
        proses.add(BarEntry(20f, 3))
        proses.add(BarEntry(20f, 4))
        proses.add(BarEntry(20f, 5))
        proses.add(BarEntry(20f, 6))
        proses.add(BarEntry(20f, 7))
        proses.add(BarEntry(20f, 8))
        proses.add(BarEntry(20f, 9))
        proses.add(BarEntry(20f, 10))
        proses.add(BarEntry(20f, 11))

        val belum = ArrayList<BarEntry>()
        belum.add(BarEntry(30f, 0))
        belum.add(BarEntry(30f,1))
        belum.add(BarEntry(30f, 2))
        belum.add(BarEntry(30f, 3))
        belum.add(BarEntry(30f, 4))
        belum.add(BarEntry(30f, 5))
        belum.add(BarEntry(30f, 6))
        belum.add(BarEntry(30f, 7))
        belum.add(BarEntry(30f, 8))
        belum.add(BarEntry(30f, 9))
        belum.add(BarEntry(30f, 10))
        belum.add(BarEntry(30f, 11))

        val barDataSet1 = BarDataSet(selesai, "Selesai")
        barDataSet1.setColor(Color.rgb(0, 155, 0))
        barDataSet1.valueTextSize = 7f

        val barDataSet2 = BarDataSet(proses, "Dproses")
        barDataSet2.setColor(Color.rgb(0, 0, 155))
        barDataSet2.valueTextSize = 7f

        val barDataSet3 = BarDataSet(belum, "Belum Selesai")
        barDataSet3.setColor(Color.rgb(155, 0, 0))
        barDataSet3.valueTextSize = 7f

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


    /*private fun tes(){

        *//*inisiasi data bar*//*
        var bar1 = ArrayList<BarEntry>()
        bar1.add(BarEntry(1f, 150f))
        bar1.add(BarEntry(2f, 150f))
        bar1.add(BarEntry(3f, 150f))
        bar1.add(BarEntry(4f, 150f))
        bar1.add(BarEntry(5f, 150f))
        bar1.add(BarEntry(6f, 150f))
        bar1.add(BarEntry(7f, 150f))
        bar1.add(BarEntry(8f, 150f))
        bar1.add(BarEntry(9f, 150f))
        bar1.add(BarEntry(10f, 150f))
        bar1.add(BarEntry(11f, 150f))
        bar1.add(BarEntry(12f, 150f))

        var bar2 = ArrayList<BarEntry>()
        bar2.add(BarEntry(1f, 100f))
        bar2.add(BarEntry(2f, 100f))
        bar2.add(BarEntry(3f, 100f))
        bar2.add(BarEntry(4f, 100f))
        bar2.add(BarEntry(5f, 100f))
        bar2.add(BarEntry(6f, 100f))
        bar2.add(BarEntry(7f, 100f))
        bar2.add(BarEntry(8f, 100f))
        bar2.add(BarEntry(9f, 100f))
        bar2.add(BarEntry(10f, 100f))
        bar2.add(BarEntry(11f, 100f))
        bar2.add(BarEntry(12f, 100f))

        var bar3 = ArrayList<BarEntry>()
        bar3.add(BarEntry(1f, 50f))
        bar3.add(BarEntry(2f, 50f))
        bar3.add(BarEntry(3f, 50f))
        bar3.add(BarEntry(4f, 50f))
        bar3.add(BarEntry(5f, 50f))
        bar3.add(BarEntry(6f, 50f))
        bar3.add(BarEntry(7f, 50f))
        bar3.add(BarEntry(8f, 50f))
        bar3.add(BarEntry(9f, 50f))
        bar3.add(BarEntry(10f, 50f))
        bar3.add(BarEntry(11f, 50f))
        bar3.add(BarEntry(12f, 50f))

        val dataSet1 = BarDataSet(bar1, "Belum Selesai")
        dataSet1.setColor(Color.parseColor("#f44336"))

        val dataSet2 = BarDataSet(bar2, "Proses")
        dataSet2.setColor(Color.parseColor("#9C27B0"))

        val dataSet3 = BarDataSet(bar3, "Selesai")
        dataSet3.setColor(Color.parseColor("#e241f4"))

        //tahun
        val tahun = ArrayList<String>()
        tahun.add("Jan")
        tahun.add("Feb")
        tahun.add("Mar")
        tahun.add("Apr")
        tahun.add("May")
        tahun.add("June")
        tahun.add("Jul")
        tahun.add("Aug")
        tahun.add("Sep")
        tahun.add("Oct")
        tahun.add("Nov")
        tahun.add("Dec")

        val data = BarData(dataSet1, dataSet2, dataSet3)
        graph_pengaduan.data = data

//        x-axis
        val xAxis = graph_pengaduan.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(tahun)
        graph_pengaduan.axisLeft.axisMinimum = 0f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setCenterAxisLabels(true)
        xAxis.isGranularityEnabled = true
        xAxis.textSize = 8f
        xAxis.labelCount = 12
        xAxis.setAvoidFirstLastClipping(true)
        xAxis.setDrawGridLines(true)



        //sizing
        val barSpace: Float = 0.10f
        val groupSpace: Float = 0.35f
        val groupCount: Int = 12

        data.barWidth = 0.25f
        graph_pengaduan.xAxis.axisMinimum = 0f
        graph_pengaduan.xAxis.axisMaximum = (0f + graph_pengaduan.barData.getGroupWidth(groupSpace, barSpace) * groupCount)
        graph_pengaduan.groupBars(0f, groupSpace, barSpace)


        graph_pengaduan.description.isEnabled = false
        graph_pengaduan.axisRight.isEnabled = false



    }

    private fun pengaduan() {
        barChartView = view!!.findViewById(R.id.graph_pengaduan)

        val barWidth: Float
        val barSpace: Float
        val groupSpace: Float
        val groupCount = 12f

        barWidth = 0.18f //gemuk/ kurusnya bar
        barSpace = 0.07f // perbar
        groupSpace = 0.25f // antar bulan

        var tahun = ArrayList<String>()
        tahun.add("Jan")
        tahun.add("Feb")
        tahun.add("Mar")
        tahun.add("Apr")
        tahun.add("May")
        tahun.add("June")
        tahun.add("Jul")
        tahun.add("Aug")
        tahun.add("Sep")
        tahun.add("Oct")
        tahun.add("Nov")
        tahun.add("Dec")

        var yValueGroup1 = ArrayList<BarEntry>()
        var yValueGroup2 = ArrayList<BarEntry>()
        var yValueGroup3 = ArrayList<BarEntry>()

        // draw the graph
        var barDataSet1: BarDataSet
        var barDataSet2: BarDataSet
        var barDataSet3: BarDataSet


        yValueGroup1.add(BarEntry(1f, 19f))
        yValueGroup2.add(BarEntry(1f, 21f))
        yValueGroup3.add(BarEntry(1f, 6f))


        yValueGroup1.add(BarEntry(2f, 24f))
        yValueGroup2.add(BarEntry(2f, 21f))
        yValueGroup3.add(BarEntry(2f, 8f))

        yValueGroup1.add(BarEntry(3f, 10f))
        yValueGroup2.add(BarEntry(3f, 10f))
        yValueGroup3.add(BarEntry(3f, 5f))

        yValueGroup1.add(BarEntry(4f, 12f))
        yValueGroup2.add(BarEntry(4f, 21f))
        yValueGroup3.add(BarEntry(4f, 5f))

        yValueGroup1.add(BarEntry(5f, 13f))
        yValueGroup2.add(BarEntry(5f, 5f))
        yValueGroup3.add(BarEntry(5f, 5f))


        yValueGroup1.add(BarEntry(6f, 12f))
        yValueGroup2.add(BarEntry(6f, 48f))
        yValueGroup3.add(BarEntry(6f, 3f))

        yValueGroup1.add(BarEntry(7f, 9f))
        yValueGroup2.add(BarEntry(7f, 22f))
        yValueGroup3.add(BarEntry(7f, 9f))


        yValueGroup1.add(BarEntry(8f, 21f))
        yValueGroup2.add(BarEntry(8f, 33f))
        yValueGroup3.add(BarEntry(8f, 20f))


        yValueGroup1.add(BarEntry(9f, 7f))
        yValueGroup2.add(BarEntry(9f, 30f))
        yValueGroup3.add(BarEntry(9f, 13f))


        yValueGroup1.add(BarEntry(10f, 18f))
        yValueGroup2.add(BarEntry(10f, 22f))
        yValueGroup3.add(BarEntry(10f, 15f))

        yValueGroup1.add(BarEntry(11f, 8f))
        yValueGroup2.add(BarEntry(11f, 47f))
        yValueGroup3.add(BarEntry(11f, 25f))

        yValueGroup1.add(BarEntry(12f, 0f))
        yValueGroup2.add(BarEntry(12f, 0f))
        yValueGroup3.add(BarEntry(12f, 0f))



        barDataSet1 = BarDataSet(yValueGroup1, "Diproses")
        barDataSet1.setColors(Color.BLUE)
        barDataSet1.valueTextSize = 5f

        barDataSet2 = BarDataSet(yValueGroup2, "Selesai")
        barDataSet2.setColors(Color.YELLOW)
        barDataSet2.valueTextSize = 5f


        barDataSet3 = BarDataSet(yValueGroup3, "Belum Diproses")
        barDataSet3.setColors(Color.RED)
        barDataSet3.valueTextSize = 5f


        var barData = BarData(barDataSet1, barDataSet2, barDataSet3)

        barChartView.description.isEnabled = false
        barChartView.description.textSize = 0f
        barData.setValueFormatter(LargeValueFormatter())
        barChartView.setData(barData)
        barChartView.getBarData().setBarWidth(barWidth)
        barChartView.getXAxis().setAxisMinimum(0f)
        barChartView.getXAxis().setAxisMaximum(groupCount)
        barChartView.groupBars(0f, groupSpace, barSpace)
        //   barChartView.setFitBars(true)
        barChartView.getData().setHighlightEnabled(false)
        barChartView.invalidate()

        // set bar label
        *//*var legend = barChartView.legend
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL)
        legend.textSize = 7f
        legend.setDrawInside(false)

        var legenedEntries = arrayListOf<LegendEntry>()

        legenedEntries.add(LegendEntry("Diproses", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.BLUE))
        legenedEntries.add(LegendEntry("Selesai", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.YELLOW))
        legenedEntries.add(LegendEntry("Belum Diproses", Legend.LegendForm.SQUARE, 8f, 4f, null, Color.RED))

        legend.setCustom(legenedEntries)

        legend.yOffset = 3f
        legend.xOffset = 1f
        legend.yEntrySpace = 2f*//*

        val l = barChartView.legend
        l.textSize = 4f
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.form = Legend.LegendForm.CIRCLE

        val xAxis = barChartView.getXAxis()
        xAxis.setGranularity(1f)
        xAxis.setGranularityEnabled(true)
        xAxis.setCenterAxisLabels(true)
        xAxis.setDrawGridLines(true)
        xAxis.textSize = 6.5f

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(IndexAxisValueFormatter(tahun))

        xAxis.setLabelCount(12)
        xAxis.mAxisMaximum = 10f
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

    }*/

    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}