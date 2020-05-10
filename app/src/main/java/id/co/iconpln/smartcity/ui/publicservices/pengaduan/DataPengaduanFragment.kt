package id.co.iconpln.smartcity.ui.publicservices.pengaduan

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.orhanobut.hawk.Hawk
import dagger.android.support.AndroidSupportInjection
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.DataPengaduanDto
import id.co.iconpln.smartcity.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_datapengaduan.*
import javax.inject.Inject


class DataPengaduanFragment : BaseFragment(),
    PengaduanViewHelper {

    @Inject
    lateinit var presenter: PengaduanPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_datapengaduan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.setView(this)
//        val a = presenter.setcityid().toString()
        val setCityId = Hawk.get<String>("coba")
        presenter.pengaduan(setCityId, "2018")


//        val intent = (context as Activity).intent

    }
    override fun onAuthFailed() {

    }

    override fun showDPengaduan(pengaduanDto: ArrayList<DataPengaduanDto>) {
        val tf: Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: ArrayList<BarDataSet>? = null
        val belum = ArrayList<BarEntry>()
        val proses = ArrayList<BarEntry>()
        val selesai = ArrayList<BarEntry>()

        for (i in pengaduanDto.indices) {
            if (pengaduanDto[i].progress_type == "Belum Diproses") {
                if (pengaduanDto[i].name == "Agu") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    belum.add(value)
                }
                else if(pengaduanDto[i].name == "Des"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Jan"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Sep") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 11)
                    belum.add(value)
                }
//                Log.e("respon", "${belum}")
//                Log.e("size", "${i}")
            } else if (pengaduanDto[i].progress_type == "Diproses") {
                if(pengaduanDto[i].name == "Agu"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Des"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Jan"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Sep") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 11)
                    proses.add(value)
                }
            } else if (pengaduanDto[i].progress_type == "Selesai") {
                if(pengaduanDto[i].name == "Agu"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Des"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Jan"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Sep"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 11)
                    selesai.add(value)
                }
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


        val barDataSet3 = BarDataSet(belum, "Belum Diproses")
        barDataSet3.setColor(Color.rgb(190, 183, 255))
        barDataSet3.valueTextSize = 8f
        barDataSet3.valueTypeface = tf
        barDataSet3.valueFormatter = LargeValueFormatter()

        dataSets = ArrayList()
        dataSets.add(barDataSet1)
        dataSets.add(barDataSet2)
        dataSets.add(barDataSet3)

        val xAxis = ArrayList<String>()
        xAxis.add("JAN")
        xAxis.add("FEB")
        xAxis.add("MAR")
        xAxis.add("APR")
        xAxis.add("MAY")
        xAxis.add("JUN")
        xAxis.add("JUL")
        xAxis.add("AGS")
        xAxis.add("SEP")
        xAxis.add("OKT")
        xAxis.add("NOV")
        xAxis.add("DES")

        val data = BarData(xAxis, dataSets)
        graph_pengaduan.data = data
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
        graph_pengaduan.setVisibleXRange(12f)
        graph_pengaduan.setTouchEnabled(true)

        graph_pengaduan.axisLeft.valueFormatter = LargeValueFormatter()
        val l = graph_pengaduan.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_pengaduan.axisRight.isEnabled = false
    }

    override fun hideButtonProgress() {
        Log.e("hide", "tes")
    }

    private fun dataSets(): ArrayList<BarDataSet> {
        val selesai = ArrayList<BarEntry>()
        selesai.add(BarEntry(10f, 0))
        selesai.add(BarEntry(10f, 1))
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
        proses.add(BarEntry(20f, 1))
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
        belum.add(BarEntry(30f, 1))
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
        barDataSet1.valueTextSize = 8f
        barDataSet1.valueFormatter = LargeValueFormatter()

        val barDataSet2 = BarDataSet(proses, "Diproses")
        barDataSet2.setColor(Color.rgb(0, 0, 155))
        barDataSet2.valueTextSize = 8f
        barDataSet2.valueFormatter = LargeValueFormatter()


        val barDataSet3 = BarDataSet(belum, "Belum Selesai")
        barDataSet3.setColor(Color.rgb(155, 0, 0))
        barDataSet3.valueTextSize = 8f
        barDataSet3.valueFormatter = LargeValueFormatter()


        val dataSets = ArrayList<BarDataSet>()
        dataSets.add(barDataSet1)
        dataSets.add(barDataSet2)
        dataSets.add(barDataSet3)

        return dataSets
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

}