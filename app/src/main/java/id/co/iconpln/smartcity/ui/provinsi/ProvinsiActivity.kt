package id.co.iconpln.smartcity.ui.provinsi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.hawk.Hawk
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.api.response.Province
import id.co.iconpln.smartcity.data.model.local.ProvinceDto
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.base.adapter.RecyclerViewItemClickListener
import id.co.iconpln.smartcity.ui.kota.KotaActivity
import kotlinx.android.synthetic.main.activity_provinsi.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*
import javax.inject.Inject

class ProvinsiActivity : BaseActivity(), RecyclerViewItemClickListener<ProvinceDto>, ProvinsiViewHelper {

    @Inject
    lateinit var presenter: ProvinsiPresenter
    @Inject
    lateinit var adapter: ProvinsiAdapter

    companion object{
        const val GET_ID_PROV = "GET_ID_PROV"
        const val GET_NAME_PROV = "GET_NAME_PROV"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provinsi)
        changeStatusBarWhite()
        setupActionBarWithBackButton(toolbar)
        supportActionBar?.title = getString(R.string.label_provinsi)

        presenter.setView(this)

        adapter = ProvinsiAdapter(this)
        adapter.setItemClickListener(this)
        rv_provinsi.layoutManager = LinearLayoutManager(this)
        rv_provinsi.adapter = adapter
        presenter.province()

//        btn_next_to_kota.setOnClickListener {
//            startActivity(Intent(this, KotaActivity::class.java))
//        }

    }

    override fun showProvince(list: ArrayList<ProvinceDto>) {
        adapter.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun hideButtonProgress() {

    }

    override fun itemClick(position: Int, item: ProvinceDto?, viewId: Int) {
        item?.let {
            Toast.makeText(applicationContext, "Memilih " + item.name, Toast.LENGTH_SHORT).show()
            val intent  = Intent(this, KotaActivity::class.java)
            intent.putExtra(GET_ID_PROV, item.id)
            intent.putExtra(GET_NAME_PROV, item.name)

            //using hawk
            val prov_name= Hawk.put("prov_name", item.name)
            startActivity(intent)
        }
    }

}
