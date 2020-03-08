package id.co.iconpln.smartcity.ui.publicservices

import id.co.iconpln.smartcity.ui.base.BasePresenter

interface PengaduanPresenter: BasePresenter<PengaduanViewHelper> {

    fun pengaduan(city_id: String, year: String)
}