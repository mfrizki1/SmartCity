package id.co.iconpln.smartcity.ui.kota

import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.ui.base.BasePresenter

interface KotaPresenter : BasePresenter<KotaViewHelper> {

    fun getCitybyId(province_id: String)

    fun setCityId(coba : String)
}