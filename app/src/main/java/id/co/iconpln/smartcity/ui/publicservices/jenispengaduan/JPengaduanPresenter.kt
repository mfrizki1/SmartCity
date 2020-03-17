package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import id.co.iconpln.smartcity.ui.base.BasePresenter

interface JPengaduanPresenter:BasePresenter<JPengaduanViewHelper>{

    fun JPengaduan(city_id:String, year:String)
}