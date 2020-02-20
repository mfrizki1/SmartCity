package id.co.iconpln.smartcity.ui.kota

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.iconpln.smartcity.ui.base.adapter.BaseAdapter
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.data.model.local.ProvinceDto
import id.co.iconpln.smartcity.ui.base.adapter.RecyclerViewItemClickListener
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiAdapter
import kotlinx.android.synthetic.main.item_kota.view.*
import lib.iconpln.fieldservice.adapter.BaseHolder

class KotaAdapter(val context: Context): BaseAdapter<CityDto, KotaAdapter.KotaHolder>(){

    override fun bindViewHolder(holder: KotaHolder, data: CityDto?) {
        data?.let {
            holder.tvNameCity.text = it.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= KotaHolder(listener,
            LayoutInflater.from(parent.context).inflate(R.layout.item_kota, parent, false)
        )


    class KotaHolder(listener: RecyclerViewItemClickListener<CityDto>, itemView:View)
        : BaseHolder<CityDto>(listener,itemView){
        val tvNameCity = itemView.txt_kota
    }

}