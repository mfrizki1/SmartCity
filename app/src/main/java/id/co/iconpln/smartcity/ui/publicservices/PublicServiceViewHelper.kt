package id.co.iconpln.smartcity.ui.publicservices

import id.co.iconpln.smartcity.data.model.local.DemograpiDto
import id.co.iconpln.smartcity.data.model.local.PerijinanDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

interface PublicServiceViewHelper :BaseViewHelper{

    fun showPerijinan(perijinanDto: ArrayList<PerijinanDto>)

    fun showDemograpi(demograpiDto: ArrayList<DemograpiDto>)

    fun hideData()
}