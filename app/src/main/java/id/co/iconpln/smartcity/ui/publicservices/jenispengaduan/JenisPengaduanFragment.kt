package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import android.content.Context
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import com.orhanobut.hawk.Hawk
import dagger.android.support.AndroidSupportInjection

import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.JPengaduanDto
import id.co.iconpln.smartcity.ui.base.BaseFragment
import id.co.iconpln.smartcity.util.ColorTempl
import kotlinx.android.synthetic.main.fragment_jenispengaduan.*
import java.text.DecimalFormat
import javax.inject.Inject

class JenisPengaduanFragment : BaseFragment(), JPengaduanViewHelper {


    @Inject
    lateinit var presenter: JPengaduanPresenter

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

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.setView(this)
        val setCityId = Hawk.get<String>("coba")
        presenter.JPengaduan(setCityId, "2018")

    }

    override fun onAuthFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showJPengaduan(jpengaduan: ArrayList<JPengaduanDto>) {

        val tf: Typeface = Typeface.createFromAsset(activity!!.assets, "fonts/GoogleSans-Regular.ttf")

        val piedata = ArrayList<Entry>()

        for (i in jpengaduan.indices) {
            if (jpengaduan[i].jenis_pengaduan_id == "infrastruktur") {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 0))
            } else if (jpengaduan[i].jenis_pengaduan_id == "pelayananPublik") {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 1))
            } else if (jpengaduan[i].jenis_pengaduan_id == "laluLintas") {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 2))
            } else if (jpengaduan[i].jenis_pengaduan_id == "umum") {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 3))
            } else if (jpengaduan[i].jenis_pengaduan_id == "transportasi") {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 4))
            } else {
                piedata.add(Entry(jpengaduan[i].round.toFloat(), 5))
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
        piePengaduan.data = data
        piePengaduan.setCenterTextTypeface(tf)

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
        l.textSize = 8f
        l.formToTextSpace = 2f
        l.stackSpace = 2f


    }

    override fun JPFailed() {
        Log.e("hide JP", "JP")
    }

    object MyValueFormatter : ValueFormatter {
        override fun getFormattedValue(value: Float): String {
            var format = DecimalFormat("#####")
            return format.format(value)
        }

    }

}

