package id.co.iconpln.smartcity.ui.publicservices.pengaduan

import id.co.iconpln.smartcity.data.model.local.DataPengaduanDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface PengaduanViewHelper: BaseViewHelper {

    fun showDPengaduan(pengaduanDto: ArrayList<DataPengaduanDto>)

    fun hideButtonProgress()
}