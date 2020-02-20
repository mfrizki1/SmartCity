package id.co.iconpln.smartcity.data.source.remote

import id.co.iconpln.smartcity.data.model.api.request.DataPengaduanRequest
import id.co.iconpln.smartcity.data.model.api.request.KotaRequest
import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import id.co.iconpln.smartcity.data.model.api.request.ProvinsiRequest
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-16.
 */
class AppRemoteSource @Inject constructor(private val api: Api){

    fun login(loginRequest: LoginRequest) = api.login(loginRequest)

    fun province() = api.getProvince()

    fun cityByProv(province_id: String) = api.getCityByProv(province_id)

    fun getDataPengaduan(dataPengaduanRequest: DataPengaduanRequest) = api.getDataPengaduan(dataPengaduanRequest)
//    fun city() = api.getCity()

}