package id.co.iconpln.smartcity.ui.kota

import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface KotaViewHelper: BaseViewHelper{

    fun showCity(list: ArrayList<CityDto>)

    fun hideButtonProgress()

}