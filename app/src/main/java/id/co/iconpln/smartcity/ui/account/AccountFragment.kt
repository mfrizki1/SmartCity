package id.co.iconpln.smartcity.ui.account

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.hawk.Hawk
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity


import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_prov.text = Hawk.get<String>("prov_name")
        txt_city.text = Hawk.get<String>("city_name")
        btn_logout.setOnClickListener {
            if(activity != null){
                startActivity(Intent(activity, ProvinsiActivity::class.java))
                activity?.finish()
            }
        }
    }

}