package id.co.iconpln.smartcity.ui.dashboard

import id.co.iconpln.smartcity.data.model.local.DataPengaduanDto
import id.co.iconpln.smartcity.data.model.local.DemograpiDto
import id.co.iconpln.smartcity.data.model.local.JPengaduanDto
import id.co.iconpln.smartcity.data.model.local.PerijinanDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface DashboardViewHelper : BaseViewHelper{

    fun showDPengaduan(pengaduanDto: ArrayList<DataPengaduanDto>)

    fun showJPengaduan(jPengaduanDto: ArrayList<JPengaduanDto>)

    fun showPerijinan(perijinanDto: ArrayList<PerijinanDto>)

    fun showDemograpi(demograpiDto: ArrayList<DemograpiDto> )

    fun hideButtonProgress()


}
