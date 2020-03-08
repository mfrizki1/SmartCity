package id.co.iconpln.smartcity.ui.dashboard

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.base.BaseFragment
import id.co.iconpln.smartcity.ui.ekonomi.EkonomiFragment
import id.co.iconpln.smartcity.ui.kota.KotaActivity.Companion.GET_NAME_CITY
import id.co.iconpln.smartcity.ui.login.LoginActivity.Companion.TO_CITY_ID
import id.co.iconpln.smartcity.ui.login.LoginPresenter
import id.co.iconpln.smartcity.ui.publicservices.PublicServicesFragment
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.DataPengaduanFragment
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*
import javax.inject.Inject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.annimon.stream.operator.IntArray
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.LargeValueFormatter
import com.github.mikephil.charting.utils.PercentFormatter
import id.co.iconpln.smartcity.data.model.local.DataPengaduanDto
import id.co.iconpln.smartcity.data.model.local.DemograpiDto
import id.co.iconpln.smartcity.data.model.local.JPengaduanDto
import id.co.iconpln.smartcity.data.model.local.PerijinanDto
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.jenispengaduanFragment
import id.co.iconpln.smartcity.util.ColorTempl


class DashboardActivity : BaseActivity(), HasSupportFragmentInjector, DashboardViewHelper {

    @Inject
    lateinit var presenter: DashboardPresenter

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    lateinit var Bottom_menu: BottomNavigationView

    companion object {
        const val CITY_ID = "CITY_ID"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        /*Bottom_menu = findViewById(R.id.Bottom_menu)
        Bottom_menu.setOnNavigationItemSelectedListener(this)

        if(savedInstanceState == null){
            Bottom_menu.setSelectedItemId(R.id.nav_home)
        }*/

        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra("NAME_CITY")

        val toCityId = intent.getStringExtra(TO_CITY_ID)
        val setCity = toCityId.toString()
        Log.e("masuk id", "${setCity}")

        presenter.setView(this)
        presenter.DPengaduan(setCity, "2018")
        presenter.JPengaduan(setCity, "2018")
        presenter.Perijinan(setCity, "2018")
        presenter.Demograpi(setCity, "2018")


        /*val fragment = DataPengaduanFragment()
        val args = Bundle().apply {
                putString("a", setCity)
        }
        fragment.arguments = args

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.tess, fragment)
            .commit()

        val a = Bundle()
        a.putString("a", setCity)

        val fragment = DataPengaduanFragment.newInstance(a)

        val fragment = DataPengaduanFragment.newInstance(toCityId)

        fragment1 = new Fragment1();
          Bundle bundle = new Bundle();
         bundle.putString("key", editTextString);
          fragment1.setArguments(bundle);*/

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun showDPengaduan(pengaduanDto: ArrayList<DataPengaduanDto>) {
        val tf: Typeface = Typeface.createFromAsset(assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: ArrayList<BarDataSet>? = null
        val belum = ArrayList<BarEntry>()
        val proses = ArrayList<BarEntry>()
        val selesai = ArrayList<BarEntry>()

        for (i in pengaduanDto.indices) {
            if (pengaduanDto[i].progress_type == "Belum Diproses") {
                if (pengaduanDto[i].name == "Jan") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    belum.add(value)
                }
                else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Agu"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Sep"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    belum.add(value)
                }else if(pengaduanDto[i].name == "Des") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 11)
                    belum.add(value)
                }
//                Log.e("respon", "${belum}")
//                Log.e("size", "${i}")
            } else if (pengaduanDto[i].progress_type == "Diproses") {
                if(pengaduanDto[i].name == "Jan"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Agu"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Sep"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    proses.add(value)
                }else if(pengaduanDto[i].name == "Des") {
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 11)
                    proses.add(value)
                }
            } else if (pengaduanDto[i].progress_type == "Selesai") {
                if(pengaduanDto[i].name == "Jan"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 0)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Feb"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 1)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Mar"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 2)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Apr"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 3)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Mei"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 4)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Jun"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 5)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Jul"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 6)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Agu"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 7)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Sep"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 8)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Okt"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 9)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Nov"){
                    val value = BarEntry(pengaduanDto[i].sum.toFloat(), 10)
                    selesai.add(value)
                }else if(pengaduanDto[i].name == "Des"){
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
        graph_DPengaduan.data = data
        graph_DPengaduan.setDescription("")
        graph_DPengaduan.animateXY(500, 500)
        graph_DPengaduan.invalidate()

        graph_DPengaduan.xAxis.position = XAxis.XAxisPosition.BOTTOM
        graph_DPengaduan.xAxis.textSize = 9f
        graph_DPengaduan.xAxis.typeface = tf
        graph_DPengaduan.xAxis.setDrawGridLines(false)
        graph_DPengaduan.setDrawGridBackground(false)
        graph_DPengaduan.setDrawBarShadow(false)
        graph_DPengaduan.isHighlightEnabled = false
        graph_DPengaduan.setVisibleXRange(7f)
        graph_DPengaduan.setTouchEnabled(true)

        graph_DPengaduan.axisLeft.valueFormatter = LargeValueFormatter()
        val l = graph_DPengaduan.legend
        l.form = Legend.LegendForm.CIRCLE
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER

        graph_DPengaduan.axisRight.isEnabled = false
    }

    override fun showJPengaduan(jPengaduanDto: ArrayList<JPengaduanDto>) {

        val tf: Typeface = Typeface.createFromAsset(assets, "fonts/GoogleSans-Regular.ttf")

        val piedata = ArrayList<Entry>()

        for (i in jPengaduanDto.indices) {
            if (jPengaduanDto[i].jenis_pengaduan_id == "infrastruktur") {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 0))
            } else if (jPengaduanDto[i].jenis_pengaduan_id == "pelayananPublik") {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 1))
            } else if (jPengaduanDto[i].jenis_pengaduan_id == "laluLintas") {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 2))
            } else if (jPengaduanDto[i].jenis_pengaduan_id == "umum") {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 3))
            } else if (jPengaduanDto[i].jenis_pengaduan_id == "transportasi") {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 4))
            } else {
                piedata.add(Entry(jPengaduanDto[i].round.toFloat(), 5))
            }

        }

        val dataSet = PieDataSet(piedata, "")
        dataSet.valueTextSize = 10f
        dataSet.setColors(ColorTempl.custom)
        dataSet.valueFormatter = PercentFormatter()
        dataSet.valueTextColor = resources.getColor(R.color.ghost_white)
        dataSet.valueTypeface = tf

        val jenis = ArrayList<String>()
        jenis.add("Infrastruktur")
        jenis.add("Pelayanan Publik")
        jenis.add("Lalu Lintas")
        jenis.add("Umum")
        jenis.add("Transportasi")
        jenis.add("Kebersihan")

        val data = PieData(jenis, dataSet)
        pie_JPengaduan.data = data
        pie_JPengaduan.setCenterTextTypeface(tf)

        pie_JPengaduan.isDrawHoleEnabled = false
        pie_JPengaduan.isRotationEnabled = true
        pie_JPengaduan.setDescription("")
        pie_JPengaduan.setDrawSliceText(true)
        pie_JPengaduan.setDrawCenterText(true)
        pie_JPengaduan.setDrawMarkerViews(true)
        pie_JPengaduan.setUsePercentValues(true)
        pie_JPengaduan.animateXY(500, 500)


        val l = pie_JPengaduan.legend
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER
        l.form = Legend.LegendForm.CIRCLE
        l.textSize = 8f
        l.formToTextSpace = 2f
        l.stackSpace = 2f


    }

    override fun showPerijinan(perijinanDto: ArrayList<PerijinanDto>) {

        val tf: Typeface =
            Typeface.createFromAsset(assets, "fonts/GoogleSans-Regular.ttf")

        var dataSets: ArrayList<BarDataSet>? = null
        val perijinanData = ArrayList<BarEntry>()

        for (i in perijinanDto.indices) {
            val value = BarEntry(perijinanDto[i].sum.toFloat(), i)
            perijinanData.add(value)
        }

        val barDataSet = BarDataSet(perijinanData, "")
        barDataSet.setColor(Color.rgb(190, 183, 255))
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
            Typeface.createFromAsset(assets, "fonts/GoogleSans-Regular.ttf")

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
        menSets.setColor(Color.rgb(255, 204, 204))
        menSets.valueTextSize = 8f
        menSets.valueTypeface = tf
        menSets.valueFormatter = LargeValueFormatter()


        val womenSets = BarDataSet(women, "Perempuan")
        womenSets.setColor(Color.rgb(190, 183, 255))
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

    override fun hideButtonProgress() {
        Log.i("infor", "just info")
    }


    /*override fun onNavigationItemSelected(item: MenuItem): Boolean {


        var fragment: Fragment? = null
        when (item.itemId){
            R.id.nav_home ->{
                fragment = DashboardFragment()
            }
            R.id.nav_public_service ->{
                fragment = PublicServicesFragment()
            }
            R.id.nav_ekonomi -> {
                fragment = EkonomiFragment()
            }
    //            R.id.nav_account -> fragment = AccountFragment()
        }
        return loadFragment(fragment)
    }
    */
    /*private fun loadFragment(fragment: Fragment?): Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.tess, fragment)
                .commit()
            return true
        }
        return false
    }*/

}
