package id.co.iconpln.smartcity.data.source.remote

import id.co.iconpln.smartcity.data.model.api.request.*
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-16.
 */
class AppRemoteSource @Inject constructor(private val api: Api){

    fun login(loginRequest: LoginRequest) = api.login(loginRequest)

    fun province() = api.getProvince()

    fun cityByProv(province_id: String) = api.getCityByProv(province_id)

    fun getDataPengaduan(dataPengaduanRequest: DataPengaduanRequest) = api.getDataPengaduan(dataPengaduanRequest)

    fun getJPengaduan(jPengaduanReq: JPengaduanReq) = api.getJPengaduan(jPengaduanReq)

    fun getPerijinan(perijinanReq: PerijinanReq) = api.getPerijinan(perijinanReq)

    fun getDemograpi(demograpiReq: DemograpiReq) = api.getDemograpi(demograpiReq)
//    fun city() = api.getCity()

}