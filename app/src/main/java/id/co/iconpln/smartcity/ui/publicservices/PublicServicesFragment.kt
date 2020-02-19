package id.co.iconpln.smartcity.ui.publicservices

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ViewPagerAdapter
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.datapengaduanFragment
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.jenispengaduanFragment
import kotlinx.android.synthetic.main.fragment_publicservices.*

class PublicServicesFragment : Fragment(), OnChartValueSelectedListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_publicservices, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTab(viewpagerPengaduan)

        val dataPerijinan = BarData(xAxisValuePerijinan(), dataSetsPerijinan())
        graphPerijinan(dataPerijinan)

        val dataDemograpi = BarData(xAxisValueDemograpi(), dataSetsDemograpi())
        graphDemograpi(dataDemograpi)



    }

    private fun setupTab(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(datapengaduanFragment(), "Data Pengaduan")
        adapter.populateFragment(jenispengaduanFragment(), "Jenis Pengaduan")
        viewPager.adapter = adapter
        tabpengaduan.setupWithViewPager(viewPager)
    }

    private fun graphPerijinan(data: BarData){
        graph_perijinan.data= data
        graph_perijinan.setDescription("")
        graph_perijinan.animateXY(500, 500)
        graph_perijinan.invalidate()

        graph_perijinan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_perijinan.xAxis.textSize = 9f
        graph_perijinan.xAxis.typeface = Typeface.DEFAULT
        graph_perijinan.xAxis.setDrawGridLines(false)
        graph_perijinan.setDrawGridBackground(false)
        graph_perijinan.setDrawBarShadow(false)
        graph_perijinan.isHighlightEnabled = false

        graph_perijinan.legend.isEnabled = false

        graph_perijinan.axisRight.isEnabled = false
    }
    private fun dataSetsPerijinan():ArrayList<BarDataSet>{
        val bar1 = ArrayList<BarEntry>()
        bar1.add(BarEntry(10f, 0))
        bar1.add(BarEntry(8f,1))
        bar1.add(BarEntry(45f, 2))
        bar1.add(BarEntry(15f, 3))
        bar1.add(BarEntry(25f, 4))
        bar1.add(BarEntry(75f, 5))
        bar1.add(BarEntry(110f, 6))
        bar1.add(BarEntry(21f, 7))
        bar1.add(BarEntry(24f, 8))
        bar1.add(BarEntry(30f, 9))
        bar1.add(BarEntry(11f, 10))
        bar1.add(BarEntry(14f, 11))

        val barDataSet1 = BarDataSet(bar1, "")
        barDataSet1.setColor(Color.rgb(0, 155, 50))
        barDataSet1.valueTextSize = 6f


        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSet1)

        return  dataSets
    }
    private fun xAxisValuePerijinan(): ArrayList<String>{
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

    private fun graphDemograpi(data: BarData){
        graph_demograpi.data = data
        graph_demograpi.setDescription("")
        graph_demograpi.animateXY(500, 500)
        graph_demograpi.invalidate()

        graph_demograpi.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_demograpi.xAxis.textSize = 9f
        graph_demograpi.xAxis.typeface = Typeface.DEFAULT
        graph_demograpi.xAxis.setDrawGridLines(false)
        graph_demograpi.setDrawGridBackground(false)
        graph_demograpi.setDrawBarShadow(false)
        graph_demograpi.isHighlightEnabled = false

        val l = graph_demograpi.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_demograpi.axisRight.isEnabled = false

    }
    private fun dataSetsDemograpi(): ArrayList<BarDataSet>{
        val barLaki = ArrayList<BarEntry>()
        barLaki.add(BarEntry(10f, 0))
        barLaki.add(BarEntry(8f,1))
        barLaki.add(BarEntry(45f, 2))
        barLaki.add(BarEntry(15f, 3))
        barLaki.add(BarEntry(25f, 4))

        val barCewe = ArrayList<BarEntry>()
        barCewe.add(BarEntry(14f, 0))
        barCewe.add(BarEntry(11f, 1))
        barCewe.add(BarEntry(30f, 2))
        barCewe.add(BarEntry(24f, 3))
        barCewe.add(BarEntry(21f, 4))

        val barDataSetCowo = BarDataSet(barLaki, "Laki-Laki")
        barDataSetCowo.setColor(Color.rgb(51, 153, 255))
        barDataSetCowo.valueTextSize = 6f

        val barDataSetCewe = BarDataSet(barCewe, "Perempuan")
        barDataSetCewe.setColor(Color.rgb(255, 51, 51))
        barDataSetCewe.valueTextSize = 6f

        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSetCewe)
        dataSets.add(barDataSetCowo)

        return  dataSets
    }
    private fun xAxisValueDemograpi(): ArrayList<String>{
        val xaxis = ArrayList<String>()
        xaxis.add("5-11")
        xaxis.add("11-17")
        xaxis.add("18-22")
        xaxis.add("23-30")
        xaxis.add("31-40")

        return xaxis
    }

    /*private fun graphDemo(){

        val barWidth = 0.25f
        val groupSpace = 0.08f
        val barSpace = 0.02f
        val awal = 5-13f

        val xAxisValue = ArrayList<String>()
        xAxisValue.add("5-13")
        xAxisValue.add("14-17")
        xAxisValue.add("18-21")
        xAxisValue.add("22-30")
        xAxisValue.add("31-40")

        val laki = ArrayList<BarEntry>()
        laki.add(BarEntry(1f, 18f))
        laki.add(BarEntry(2f, 20f))
        laki.add(BarEntry(3f, 25f))
        laki.add(BarEntry(4f, 10f))
        laki.add(BarEntry(5f, 11f))

        val perempuan = ArrayList<BarEntry>()
        perempuan.add(BarEntry(1f, 11f))
        perempuan.add(BarEntry(2f, 10f))
        perempuan.add(BarEntry(3f, 15f))
        perempuan.add(BarEntry(4f, 8f))
        perempuan.add(BarEntry(5f, 22f))

        val dataSetCowo = BarDataSet(laki, "Laki-Laki")
        dataSetCowo.setColor(Color.BLUE)
        dataSetCowo.valueTextSize = 5f


        val dataSetCewe = BarDataSet(perempuan, "Perempuan")
        dataSetCewe.setColor(Color.MAGENTA)
        dataSetCewe.valueTextSize = 5f

        val data = BarData(dataSetCowo, dataSetCewe)

        graph_demograpi.data = data
        graph_demograpi.description.isEnabled = false
        graph_demograpi.barData.barWidth = barWidth
        graph_demograpi.xAxis.axisMinimum = 0f


        val l = graph_demograpi.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.form = Legend.LegendForm.CIRCLE

        val xAxis = graph_demograpi.getXAxis()
        xAxis.setGranularity(1f)
        xAxis.setGranularityEnabled(true)
        xAxis.setCenterAxisLabels(true)
        xAxis.setDrawGridLines(true)
        xAxis.textSize = 6.5f
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValue))
        graph_demograpi.invalidate()


    }*/


    override fun onNothingSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {

    }


}



/*    private fun chartPengaduan(){
        piePengaduan = view!!.findViewById(R.id.graph_pengaduan)

        val barentry = ArrayList<String>()
    }

    private fun graphPengaduan() {
        barChartView = view!!.findViewById(R.id.graph_pengaduan)

        val barWidth: Float = 0.18f
        val barSpace: Float = 0.07f
        val groupSpace: Float = 0.25f
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

    private fun piePengaduan() {
        barChartView = view!!.findViewById(R.id.graph_pengaduan)
//        var barChartView = findViewById<BarChart>(R.id.graph_pengaduan)

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
//        var yValueGroup3 = ArrayList<BarEntry>()

        // draw the graph
        var barDataSet1: BarDataSet
        var barDataSet2: BarDataSet
//        var barDataSet3: BarDataSet


        yValueGroup1.add(BarEntry(1f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(1f, floatArrayOf(2.toFloat(), 7.toFloat())))
//        yValueGroup3.add(BarEntry(1f, floatArrayOf(24.toFloat(), 13.toFloat())))


        yValueGroup1.add(BarEntry(2f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(2f, floatArrayOf(4.toFloat(), 15.toFloat())))
//        yValueGroup3.add(BarEntry(2f, floatArrayOf(3.toFloat(), 1.toFloat())))

        yValueGroup1.add(BarEntry(3f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(3f, floatArrayOf(4.toFloat(), 15.toFloat())))
//        yValueGroup3.add(BarEntry(3f, floatArrayOf(4.toFloat(), 10.toFloat())))

        yValueGroup1.add(BarEntry(4f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(4f, floatArrayOf(4.toFloat(), 15.toFloat())))
//        yValueGroup3.add(BarEntry(4f, floatArrayOf(14.toFloat(), 20.toFloat())))


        yValueGroup1.add(BarEntry(5f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(5f, floatArrayOf(10.toFloat(), 6.toFloat())))
//        yValueGroup3.add(BarEntry(5f, floatArrayOf(6.toFloat(), 3.toFloat())))

        yValueGroup1.add(BarEntry(6f, floatArrayOf(11.toFloat(), 1.toFloat())))
        yValueGroup2.add(BarEntry(6f, floatArrayOf(12.toFloat(), 2.toFloat())))
//        yValueGroup3.add(BarEntry(6f, floatArrayOf(8.toFloat(), 20.toFloat())))


        yValueGroup1.add(BarEntry(7f, floatArrayOf(11.toFloat(), 7.toFloat())))
        yValueGroup2.add(BarEntry(7f, floatArrayOf(12.toFloat(), 12.toFloat())))
//        yValueGroup3.add(BarEntry(7f, floatArrayOf(4.toFloat(), 14.toFloat())))


        yValueGroup1.add(BarEntry(8f, floatArrayOf(11.toFloat(), 9.toFloat())))
        yValueGroup2.add(BarEntry(8f, floatArrayOf(12.toFloat(), 8.toFloat())))
//        yValueGroup3.add(BarEntry(8f, floatArrayOf(6.toFloat(), 8.toFloat())))


        yValueGroup1.add(BarEntry(9f, floatArrayOf(11.toFloat(), 13.toFloat())))
        yValueGroup2.add(BarEntry(9f, floatArrayOf(12.toFloat(), 12.toFloat())))
//        yValueGroup3.add(BarEntry(9f, floatArrayOf(19.toFloat(), 20.toFloat())))

        yValueGroup1.add(BarEntry(10f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(10f, floatArrayOf(12.toFloat(), 7.toFloat())))
//        yValueGroup3.add(BarEntry(10f, floatArrayOf(17.toFloat(), 7.toFloat())))

        yValueGroup1.add(BarEntry(11f, floatArrayOf(11.toFloat(), 6.toFloat())))
        yValueGroup2.add(BarEntry(11f, floatArrayOf(12.toFloat(), 5.toFloat())))
//        yValueGroup3.add(BarEntry(11f, floatArrayOf(22.toFloat(), 12.toFloat())))

        yValueGroup1.add(BarEntry(12f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(12f, floatArrayOf(12.toFloat(), 3.toFloat())))
//        yValueGroup3.add(BarEntry(12f, floatArrayOf(20.toFloat(), 10.toFloat())))


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

//        barDataSet3 = BarDataSet(yValueGroup3, "")
//        barDataSet3.setColors(Color.RED)
//        barDataSet3.label = "Belum Diproses"
//        barDataSet3.setDrawIcons(false)
//        barDataSet3.setDrawValues(false)

        var barData = BarData(barDataSet1, barDataSet2)

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

        legend.setYOffset(3f)
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
    }*/

