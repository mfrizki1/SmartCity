package id.co.iconpln.smartcity.ui.ekonomi.pembiayaandesa

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.PercentFormatter

import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ColorTempl
import kotlinx.android.synthetic.main.fragment_total_pembiayaan_desa.*

class TotalPembiayaanDesaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_total_pembiayaan_desa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = ArrayList<Entry>()
        value.add(Entry(12f, 0))
        value.add(Entry(23f, 1))
        value.add(Entry(78f, 2))

        val dataSet = PieDataSet(value, "")
        dataSet.valueTextSize = 12f
        dataSet.setColors(ColorTempl.custom)
        dataSet.valueTextColor = resources.getColor(R.color.ghost_white)
        dataSet.valueFormatter = PercentFormatter()

        val ttlpmebiayaan = ArrayList<String>()
        ttlpmebiayaan.add("Gaji Perangkat Desa")
        ttlpmebiayaan.add("Pemeliharaan Infrasturktur")
        ttlpmebiayaan.add("Rapat Kerja")

        val data = PieData(ttlpmebiayaan, dataSet)
        pieTotalbiayadesa.data = data

        pieTotalbiayadesa.isDrawHoleEnabled = false
        pieTotalbiayadesa.isRotationEnabled = true
        pieTotalbiayadesa.setDescription("")
        pieTotalbiayadesa.setTouchEnabled(true)
        pieTotalbiayadesa.setDrawSliceText(true)
        pieTotalbiayadesa.setDrawCenterText(true)
        pieTotalbiayadesa.animateXY(500, 500)


/*        //markerview
        val mv = CustomMarkerView(context, R.layout.custom_marker_view_layout)
        pieTotalbiayadesa.markerView = mv*/

        //legend
        val l = pieTotalbiayadesa.legend
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER
        l.form = Legend.LegendForm.CIRCLE
        l.direction = Legend.LegendDirection.LEFT_TO_RIGHT
        l.textSize = 8f
        l.formToTextSpace = 2f
        l.stackSpace = 2f

    }


}
