package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import id.co.iconpln.smartcity.data.model.local.JPengaduanDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface JPengaduanViewHelper:BaseViewHelper{
    fun showJPengaduan(jpengaduan: ArrayList<JPengaduanDto>)

    fun JPFailed()
}