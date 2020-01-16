package id.co.iconpln.smartcity.data.source.remote

import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-16.
 */
class AppRemoteSource @Inject constructor(private val api: Api){

    fun login(request: LoginRequest) = api.login(request)

}