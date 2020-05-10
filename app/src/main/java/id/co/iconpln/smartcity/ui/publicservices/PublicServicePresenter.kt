package id.co.iconpln.smartcity.ui.publicservices

import id.co.iconpln.smartcity.ui.base.BasePresenter

interface PublicServicePresenter: BasePresenter<PublicServiceViewHelper> {

    fun perijinan(city_id: String, year: String)

    fun demograpi(city_id: String, year: String)
}