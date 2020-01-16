package id.co.iconpln.smartcity.ui.ekonomi

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.iconpln.smartcity.R
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_ekonomi.*

class EkonomiFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?)= inflater.inflate(R.layout.fragment_ekonomi, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_graph_apbd.setOnClickListener(this)
        txt_total_apbd.setOnClickListener(this)
        txt_graph_pendapatan_desa.setOnClickListener(this)
        txt_total_pendapatan_desa.setOnClickListener(this)
        txt_graph_pembiayaan_desa.setOnClickListener(this)
        txt_total_pembiayaan_desa.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val item_id = v?.id
        when(item_id){
            R.id.txt_graph_apbd->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_total_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))

                txt_graph_apbd.setTypeface(null, Typeface.BOLD)
                txt_total_apbd.setTypeface(null, Typeface.NORMAL)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_total_apbd->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_total_apbd.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))

                txt_graph_apbd.setTypeface(null, Typeface.NORMAL)
                txt_total_apbd.setTypeface(null, Typeface.BOLD)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_graph_pendapatan_desa->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_total_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))

                txt_graph_apbd.setTypeface(null, Typeface.NORMAL)
                txt_total_apbd.setTypeface(null, Typeface.NORMAL)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.BOLD)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_total_pendapatan_desa->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_total_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))

                txt_graph_apbd.setTypeface(null, Typeface.NORMAL)
                txt_total_apbd.setTypeface(null, Typeface.NORMAL)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.BOLD)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_graph_pembiayaan_desa->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_total_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.colorPrimary))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))

                txt_graph_apbd.setTypeface(null, Typeface.NORMAL)
                txt_total_apbd.setTypeface(null, Typeface.NORMAL)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.BOLD)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
            }

            R.id.txt_total_pembiayaan_desa->{
                txt_graph_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_total_apbd.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pendapatan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_graph_pembiayaan_desa.setTextColor(resources.getColor(R.color.grey))
                txt_total_pembiayaan_desa.setTextColor(resources.getColor(R.color.colorPrimary))

                txt_graph_apbd.setTypeface(null, Typeface.NORMAL)
                txt_total_apbd.setTypeface(null, Typeface.NORMAL)
                txt_graph_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pendapatan_desa.setTypeface(null, Typeface.NORMAL)
                txt_graph_pembiayaan_desa.setTypeface(null, Typeface.NORMAL)
                txt_total_pembiayaan_desa.setTypeface(null, Typeface.BOLD)
            }
        }
    }


}