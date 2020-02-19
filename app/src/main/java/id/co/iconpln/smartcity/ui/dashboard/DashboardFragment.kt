package id.co.iconpln.smartcity.ui.dashboard

import android.content.Context
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*

class DashboardFragment : Fragment(), View.OnClickListener{

    private lateinit var dashboardPagerAdapter: DashboardPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_jumlahPengaduan.setOnClickListener(this)
        txt_apbd.setOnClickListener (this)
        txt_pajak.setOnClickListener(this)
        txt_kesehatan.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        val item_id = v?.id
        when(item_id){
            R.id.txt_jumlahPengaduan->{
                txt_jumlahPengaduan.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_pajak.setTextColor(resources.getColor(R.color.grey))
                txt_kesehatan.setTextColor(resources.getColor(R.color.grey))

                txt_jumlahPengaduan.setTypeface(null, Typeface.BOLD)
                txt_apbd.setTypeface(null, Typeface.NORMAL)
                txt_pajak.setTypeface(null, Typeface.NORMAL)
                txt_kesehatan.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_apbd->{
                txt_apbd.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_jumlahPengaduan.setTextColor(resources.getColor(R.color.grey))
                txt_pajak.setTextColor(resources.getColor(R.color.grey))
                txt_kesehatan.setTextColor(resources.getColor(R.color.grey))

                txt_apbd.setTypeface(null, Typeface.BOLD)
                txt_jumlahPengaduan.setTypeface(null, Typeface.NORMAL)
                txt_pajak.setTypeface(null, Typeface.NORMAL)
                txt_kesehatan.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_pajak->{
                txt_pajak.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_jumlahPengaduan.setTextColor(resources.getColor(R.color.grey))
                txt_kesehatan.setTextColor(resources.getColor(R.color.grey))

                txt_pajak.setTypeface(null, Typeface.BOLD)
                txt_jumlahPengaduan.setTypeface(null, Typeface.NORMAL)
                txt_apbd.setTypeface(null, Typeface.NORMAL)
                txt_kesehatan.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_kesehatan->{
                txt_kesehatan.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_pajak.setTextColor(resources.getColor(R.color.grey))
                txt_jumlahPengaduan.setTextColor(resources.getColor(R.color.grey))

                txt_kesehatan.setTypeface(null, Typeface.BOLD)
                txt_jumlahPengaduan.setTypeface(null, Typeface.NORMAL)
                txt_apbd.setTypeface(null, Typeface.NORMAL)
                txt_pajak.setTypeface(null, Typeface.NORMAL)
            }
        }
    }

}