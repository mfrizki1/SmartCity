package id.co.iconpln.smartcity.data.repository

import id.co.iconpln.smartcity.data.model.api.request.DataPengaduanRequest
import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import id.co.iconpln.smartcity.data.model.local.ProvinceDto
import id.co.iconpln.smartcity.data.model.local.UserDto
import id.co.iconpln.smartcity.data.source.pref.AppPrefSource
import id.co.iconpln.smartcity.data.source.remote.AppRemoteSource
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-14.
 */
class UserRepository @Inject constructor(val api: AppRemoteSource, val pref: AppPrefSource) {

    fun getUser(): UserDto? {
        return pref.getUser()
    }


    fun login(loginRequest: LoginRequest) = api.login(loginRequest)

    fun province() = api.province()

    fun city(province_id: String) = api.cityByProv(province_id)

    fun getDataPengaduan(dataPengaduanRequest: DataPengaduanRequest) = api.getDataPengaduan(dataPengaduanRequest)
//    fun city() = api.city()

}