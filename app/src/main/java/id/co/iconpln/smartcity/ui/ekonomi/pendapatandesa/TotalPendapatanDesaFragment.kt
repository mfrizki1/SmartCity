package id.co.iconpln.smartcity.ui.ekonomi.pendapatandesa

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
import kotlinx.android.synthetic.main.fragment_total_pendapatan_desa.*


class TotalPendapatanDesaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_total_pendapatan_desa, container, false)
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

        val ttlpndptndesa = ArrayList<String>()
        ttlpndptndesa.add("BUMDes")
        ttlpndptndesa.add("Dana Desa")
        ttlpndptndesa.add("Swadaya")

        val data = PieData(ttlpndptndesa, dataSet)
        pieTotalpendapatandesa.data = data

        pieTotalpendapatandesa.isDrawHoleEnabled = false
        pieTotalpendapatandesa.isRotationEnabled = true
        pieTotalpendapatandesa.setDescription("")
        pieTotalpendapatandesa.setTouchEnabled(true)
        pieTotalpendapatandesa.setDrawSliceText(true)
        pieTotalpendapatandesa.setDrawCenterText(true)
        pieTotalpendapatandesa.animateXY(500, 500)


/*        //markerview
        val mv = CustomMarkerView(context, R.layout.custom_marker_view_layout)
        pieTotalpendapatandesa.markerView = mv*/

        //legend
        val l = pieTotalpendapatandesa.legend
        l.position = Legend.LegendPosition.BELOW_CHART_CENTER
        l.form = Legend.LegendForm.CIRCLE
        l.direction = Legend.LegendDirection.LEFT_TO_RIGHT
        l.textSize = 8f
        l.formToTextSpace = 2f
        l.stackSpace = 2f
    }

}
