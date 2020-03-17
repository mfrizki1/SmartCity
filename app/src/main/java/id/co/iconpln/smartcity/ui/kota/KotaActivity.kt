package id.co.iconpln.smartcity.ui.kota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.ui.base.BaseActivity
import id.co.iconpln.smartcity.ui.base.adapter.RecyclerViewItemClickListener
import id.co.iconpln.smartcity.ui.login.LoginActivity
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity.Companion.GET_ID_PROV
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity.Companion.GET_NAME_PROV
import kotlinx.android.synthetic.main.activity_kota.*
import kotlinx.android.synthetic.main.layout_toolbar_white.*
import javax.inject.Inject

class KotaActivity : BaseActivity(), RecyclerViewItemClickListener<CityDto>, KotaViewHelper {

    @Inject
    lateinit var presenter: KotaPresenter

    @Inject
    lateinit var adapter: KotaAdapter
    companion object{
        const val GET_ID_CITY = "GET_ID_CITY"
        const val GET_NAME_CITY = "GET_NAME_CITY"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kota)
        changeStatusBarWhite()
        setupActionBarWithBackButton(toolbar)
        supportActionBar?.title = getString(R.string.label_kota)

        presenter.setView(this)

        val intent = getIntent()
        var getId = intent.getStringExtra(GET_ID_PROV)
        presenter.getCitybyId(getId)

        adapter = KotaAdapter(this)
        adapter.setItemClickListener(this)
        rv_kota.layoutManager = LinearLayoutManager(this)
        rv_kota.adapter = adapter

    }
    override fun showCity(list: ArrayList<CityDto>) {
        adapter.addAll(list)
        adapter.notifyDataSetChanged()
    }
    override fun hideButtonProgress() {
    }

    override fun itemClick(position: Int, item: CityDto?, viewId: Int) {
        item?.let {
            Toast.makeText(applicationContext, "Memilih " + item.name, Toast.LENGTH_SHORT).show()
            presenter.setCityId(item.id)

            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.putExtra(GET_ID_CITY, item.id)
            intent.putExtra("CITY_NAME", item.name)
            startActivity(intent)


//            intent.putExtra(GET_NAME_CITY, item.name)
        }
    }
}
