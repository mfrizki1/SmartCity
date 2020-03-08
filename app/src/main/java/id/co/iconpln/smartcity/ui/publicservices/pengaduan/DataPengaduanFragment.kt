package id.co.iconpln.smartcity.ui.publicservices.pengaduan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
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
import com.github.mikephil.charting.utils.LargeValueFormatter
import dagger.android.AndroidInjection
import dagger.android.HasFragmentInjector
import dagger.android.support.AndroidSupportInjection
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.DataPengaduanDto
import id.co.iconpln.smartcity.ui.base.BaseFragment
import id.co.iconpln.smartcity.ui.details.detailpengaduan.DetailDPengaduan
import id.co.iconpln.smartcity.ui.dashboard.DashboardActivity.Companion.CITY_ID
import kotlinx.android.synthetic.main.fragment_datapengaduan.*
import id.co.iconpln.smartcity.ui.publicservices.PengaduanPresenter
import id.co.iconpln.smartcity.ui.publicservices.PengaduanViewHelper
import java.util.zip.DataFormatException
import javax.inject.Inject


class DataPengaduanFragment: BaseFragment(), PengaduanViewHelper{

   @Inject
   lateinit var presenter: PengaduanPresenter


    companion object{
        const val TO_CITY_ID  = "TO_CITY_ID"

//        fun newInstance(cityId : String) : DataPengaduanFragment{
//            val fragment = DataPengaduanFragment()
//            val bundle = Bundle().apply {
//                putString("a", cityId)
//            }
//            fragment.arguments = bundle
//            return fragment
//        }

        fun newInstance(b : Bundle){
            val frag = DataPengaduanFragment()
            frag.arguments = b
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_datapengaduan, container, false)
        val a = this.arguments?.getString("key")
        Log.e("A","${a}")
        return view


    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.setView(this)


//        val intent = (context as Activity).intent

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( arguments != null){
            Log.e("masuk kada", "argument not null")
            val cityId = arguments?.getString("a").toString()
            presenter.pengaduan(cityId, "2018")
        }else{
            Log.e("kada masuk", "getArgument is null")
        }

//        try{
//            val cityId = arguments?.getString("a")
//            if(cityId != null){
//                presenter.pengaduan(cityId, "2018")
//            }else{
//                presenter.pengaduan("", "")
//
//            }
//        }catch (ex: Exception){
//            ex.stackTrace
//        }

    }

    override fun showDPengaduan(pengaduanDto: ArrayList<DataPengaduanDto>){

        val tf : Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: java.util.ArrayList<BarDataSet>? = null
        val belum = ArrayList<BarEntry>()
        val proses = ArrayList<BarEntry>()
        val selesai = ArrayList<BarEntry>()

        for(i in pengaduanDto.indices){
            if(pengaduanDto[i].progress_type == "Belum Diproses"){
                val value  = BarEntry(pengaduanDto[i].sum.toFloat(), i)
                belum.add(value)
//                Log.e("respon", "${belum}")
//                Log.e("size", "${i}")
            }
            else if(pengaduanDto[i].progress_type == "Diproses"){
                val value = BarEntry(pengaduanDto[i].sum.toFloat(), i)
                proses.add(value)
            }else{
                val value = BarEntry(pengaduanDto[i].sum.toFloat(), i)
                selesai.add(value)
            }
        }

        val barDataSet1 = BarDataSet(selesai, "Selesai")
        barDataSet1.setColor(Color.rgb(204, 232, 255))
        barDataSet1.valueTextSize = 8f
        barDataSet1.valueTypeface = tf
        barDataSet1.valueFormatter = LargeValueFormatter()

        val barDataSet2 = BarDataSet(proses, "Diproses")
        barDataSet2.setColor(Color.rgb(255, 204, 204))
        barDataSet2.valueTextSize = 8f
        barDataSet2.valueTypeface = tf
        barDataSet2.valueFormatter = LargeValueFormatter()


        val barDataSet3 = BarDataSet(belum, "Belum Selesai")
        barDataSet3.setColor(Color.rgb(190, 183, 255))
        barDataSet3.valueTextSize = 8f
        barDataSet3.valueTypeface = tf
        barDataSet3.valueFormatter = LargeValueFormatter()

        dataSets = ArrayList()
        dataSets.add(barDataSet1)
        dataSets.add(barDataSet2)
        dataSets.add(barDataSet3)

        val xAxis = ArrayList<String>()
        for(i in pengaduanDto.indices){
            for(month in pengaduanDto[i].name){
                xAxis.add(month.toString())
                Log.e("size", "${month}")

            }
        }

        val data =BarData(xAxis, dataSets)
        graph_pengaduan.data= data
        graph_pengaduan.setDescription("")
        graph_pengaduan.animateXY(500, 500)
        graph_pengaduan.invalidate()

        graph_pengaduan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_pengaduan.xAxis.textSize = 9f
        graph_pengaduan.xAxis.typeface = tf
        graph_pengaduan.xAxis.setDrawGridLines(false)
        graph_pengaduan.setDrawGridBackground(false)
        graph_pengaduan.setDrawBarShadow(false)
        graph_pengaduan.isHighlightEnabled = false
        graph_pengaduan.setVisibleXRange(7f)
        graph_pengaduan.setTouchEnabled(true)

        graph_pengaduan.axisLeft.valueFormatter = LargeValueFormatter()
        val l = graph_pengaduan.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_pengaduan.axisRight.isEnabled = false
    }



    override fun onAuthFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideButtonProgress() {
        Log.e("response", "error")

    }

    /*private fun dataSets():ArrayList<BarDataSet>{
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

    val tf : Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")


    val barDataSet1 = BarDataSet(selesai, "Selesai")
    barDataSet1.setColor(Color.rgb(204, 232, 255))
    barDataSet1.valueTextSize = 8f
    barDataSet1.valueTypeface = tf
    barDataSet1.valueFormatter = LargeValueFormatter()

    val barDataSet2 = BarDataSet(proses, "Diproses")
    barDataSet2.setColor(Color.rgb(255, 204, 204))
    barDataSet2.valueTextSize = 8f
    barDataSet2.valueTypeface = tf
    barDataSet2.valueFormatter = LargeValueFormatter()


    val barDataSet3 = BarDataSet(belum, "Belum Selesai")
    barDataSet3.setColor(Color.rgb(190, 183, 255))
    barDataSet3.valueTextSize = 8f
    barDataSet3.valueTypeface = tf
    barDataSet3.valueFormatter = LargeValueFormatter()


    val dataSets = ArrayList<BarDataSet>()
    dataSets.add(barDataSet1)
    dataSets.add(barDataSet2)
    dataSets.add(barDataSet3)

    return  dataSets
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
*/


 /*   override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
        Log.e("entry seelcted", e.toString())
        startActivity(Intent(this.activity, DetailDPengaduan::class.java))
    }*/
}