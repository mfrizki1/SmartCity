package id.co.iconpln.smartcity.ui.publicservices

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.Highlight
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.orhanobut.hawk.Hawk
import dagger.android.support.AndroidSupportInjection
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.DemograpiDto
import id.co.iconpln.smartcity.data.model.local.PerijinanDto
import id.co.iconpln.smartcity.ui.base.BaseFragment
import id.co.iconpln.smartcity.util.ViewPagerAdapter
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.DataPengaduanFragment
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.JenisPengaduanFragment
import kotlinx.android.synthetic.main.fragment_publicservices.*
import javax.inject.Inject

class PublicServicesFragment : BaseFragment(), PublicServiceViewHelper{


    @Inject
    lateinit var presenter: PublicServicePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_publicservices, container, false)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.setView(this)
//        val a = presenter.setcityid().toString()
        val setCityId = Hawk.get<String>("coba")
        presenter.perijinan(setCityId, "2018")
        presenter.demograpi(setCityId, "2018")


//        val intent = (context as Activity).intent

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTab(viewpagerPengaduan)

//        val dataPerijinan = BarData(xAxisValuePerijinan(), dataSetsPerijinan())
//        graphPerijinan(dataPerijinan)
//
//        val dataDemograpi = BarData(xAxisValueDemograpi(), dataSetsDemograpi())
//        graphDemograpi(dataDemograpi)

    }

    override fun onAuthFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPerijinan(perijinanDto: ArrayList<PerijinanDto>) {
        val tf: Typeface =
            Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: ArrayList<BarDataSet>? = null
        val perijinanData = ArrayList<BarEntry>()

        for (i in perijinanDto.indices) {
            val value = BarEntry(perijinanDto[i].sum.toFloat(), i)
            perijinanData.add(value)
        }
        val barDataSet = BarDataSet(perijinanData, "")
        barDataSet.setColor(Color.rgb(204, 232, 255))
        barDataSet.valueTextSize = 8f
        barDataSet.valueTypeface = tf
        barDataSet.valueFormatter = LargeValueFormatter()

        dataSets = ArrayList()
        dataSets.add(barDataSet)

        val xAxis = ArrayList<String>()
        xAxis.add("Jan")
        xAxis.add("Feb")
        xAxis.add("Mar")
        xAxis.add("Apr")
        xAxis.add("Mei")
        xAxis.add("Jun")
        xAxis.add("Jul")
        xAxis.add("Agu")
        xAxis.add("Sep")
        xAxis.add("Okt")
        xAxis.add("Nov")
        xAxis.add("Des")

        val data = BarData(xAxis, dataSets)

        graph_perijinan.data = data
        graph_perijinan.setDescription("")
        graph_perijinan.animateXY(500, 500)
        graph_perijinan.invalidate()

        graph_perijinan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_perijinan.xAxis.textSize = 9f
        graph_perijinan.xAxis.typeface = tf
        graph_perijinan.xAxis.setDrawGridLines(false)
        graph_perijinan.setDrawGridBackground(false)
        graph_perijinan.setDrawBarShadow(false)
        graph_perijinan.isHighlightEnabled = false
        graph_perijinan.setVisibleXRange(7f)


        graph_perijinan.legend.isEnabled = false

        graph_perijinan.axisRight.isEnabled = false
        graph_perijinan.axisLeft.valueFormatter = LargeValueFormatter()
    }

    override fun showDemograpi(demograpiDto: ArrayList<DemograpiDto>) {
        val tf: Typeface =
            Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: ArrayList<BarDataSet>? = null
        val men = ArrayList<BarEntry>()
        val women = ArrayList<BarEntry>()

        for (i in demograpiDto.indices) {
            if (demograpiDto[i].demographics_type == "Laki-laki") {
                if (demograpiDto[i].name == "5 - 13") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 0)
                    men.add(value)
                } else if (demograpiDto[i].name == "14 - 17") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 1)
                    men.add(value)
                } else if (demograpiDto[i].name == "18 - 21") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 2)
                    men.add(value)
                } else if (demograpiDto[i].name == "22 - 30") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 3)
                    men.add(value)
                } else {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 4)
                    men.add(value)
                }

            } else if (demograpiDto[i].demographics_type == "Perempuan") {
                if (demograpiDto[i].name == "5 - 13") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 0)
                    women.add(value)
                } else if (demograpiDto[i].name == "14 - 17") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 1)
                    women.add(value)
                } else if (demograpiDto[i].name == "18 - 21") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 2)
                    women.add(value)
                } else if (demograpiDto[i].name == "22 - 30") {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 3)
                    women.add(value)
                } else {
                    val value = BarEntry(demograpiDto[i].value.toFloat(), 4)
                    women.add(value)
                }

            }
        }

        val menSets = BarDataSet(men, "Laki-Laki")

        menSets.setColor(Color.rgb(204, 232, 255))
        menSets.valueTextSize = 8f
        menSets.valueTypeface = tf
        menSets.valueFormatter = LargeValueFormatter()


        val womenSets = BarDataSet(women, "Perempuan")
        womenSets.setColor(Color.rgb(255, 204, 204))
        womenSets.valueTextSize = 8f
        womenSets.valueTypeface = tf
        womenSets.valueFormatter = LargeValueFormatter()

        dataSets = ArrayList()
        dataSets.add(menSets)
        dataSets.add(womenSets)

        val xAxis = ArrayList<String>()
        xAxis.add("5 - 13")
        xAxis.add("14 - 17")
        xAxis.add("18 - 21")
        xAxis.add("22 - 30")
        xAxis.add("31 - 40")

        val data = BarData(xAxis, dataSets)

        graph_demograpi.data = data
        graph_demograpi.setDescription("")
        graph_demograpi.animateXY(500, 500)
        graph_demograpi.invalidate()

        graph_demograpi.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_demograpi.xAxis.textSize = 9f
        graph_demograpi.xAxis.typeface = tf
        graph_demograpi.xAxis.setDrawGridLines(false)
        graph_demograpi.setDrawGridBackground(false)
        graph_demograpi.setDrawBarShadow(false)
        graph_demograpi.isHighlightEnabled = false
        graph_demograpi.setVisibleXRange(7f)

        graph_demograpi.axisRight.isEnabled = false
        graph_demograpi.axisLeft.valueFormatter = LargeValueFormatter()

        val l = graph_demograpi.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER
    }

    override fun hideData() {
        Log.i("infor", "just info")
    }

    private fun setupTab(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(DataPengaduanFragment(), "Data Pengaduan")
        adapter.populateFragment(JenisPengaduanFragment(), "Jenis Pengaduan")
        viewPager.adapter = adapter
        tabpengaduan.setupWithViewPager(viewPager)
    }

}

