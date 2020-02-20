package id.co.iconpln.smartcity.ui.provinsi

import id.co.iconpln.smartcity.data.model.api.response.Province
import id.co.iconpln.smartcity.data.model.local.ProvinceDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface ProvinsiViewHelper : BaseViewHelper{

    fun showProvince(list: ArrayList<ProvinceDto>)

    fun hideButtonProgress()

}
