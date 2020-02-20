package id.co.iconpln.smartcity.ui.provinsi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.ProvinceDto
import id.co.iconpln.smartcity.ui.base.adapter.BaseAdapter
import id.co.iconpln.smartcity.ui.base.adapter.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.item_provinsi.view.*
import lib.iconpln.fieldservice.adapter.BaseHolder

class ProvinsiAdapter(val context: Context): BaseAdapter<ProvinceDto, ProvinsiAdapter.ProvinsiHolder>(){
    override fun bindViewHolder(holder: ProvinsiHolder, data: ProvinceDto?) {
        data?.let {
            holder.tvNameProvince.text = it.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int)= ProvinsiHolder(listener,
        LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi, parent, false))

    class ProvinsiHolder(listener: RecyclerViewItemClickListener<ProvinceDto>,itemView: View)
        : BaseHolder<ProvinceDto>(listener, itemView){
        val tvNameProvince = itemView.txt_provinsi
    }

}


