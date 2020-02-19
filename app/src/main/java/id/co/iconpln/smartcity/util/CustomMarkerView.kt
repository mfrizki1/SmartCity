package id.co.iconpln.smartcity.util

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry

import id.co.iconpln.smartcity.R


class CustomMarkerView(context: Context?, layoutResource: Int) :
    MarkerView(context, layoutResource) {
    val tvContent = findViewById<TextView>(R.id.tvContent)

    override fun refreshContent(e: Entry, dataSetIndex: Int) {
        tvContent.setText("" + e.`val`)
    }

    override fun getYOffset(): Int {
        return -(width / 2)
    }

    override fun getXOffset(): Int {
        return  -height
    }

}