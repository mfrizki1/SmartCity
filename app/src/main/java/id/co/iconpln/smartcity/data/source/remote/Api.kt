package id.co.iconpln.smartcity.data.source.remote

import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import id.co.iconpln.smartcity.data.model.api.response.BaseResponse
import id.co.iconpln.smartcity.util.Constant
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


@JvmSuppressWildcards
interface Api {

    companion object {
        const val VERSION                 = Constant.API_VERSION
        const val LOGIN                   = "${VERSION}auth/login"

    }

    @POST(LOGIN)
    fun login(@Body request: LoginRequest) : Observable<BaseResponse<String>>
}