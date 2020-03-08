package id.co.iconpln.smartcity.ui.dashboard

import id.co.iconpln.smartcity.ui.base.BasePresenter

interface DashboardPresenter : BasePresenter<DashboardViewHelper> {

    fun DPengaduan(city_id: String, year: String)

    fun JPengaduan(city_id: String, year: String)

    fun Perijinan(city_id: String, year: String)

    fun Demograpi(city_id: String, year: String)



}
