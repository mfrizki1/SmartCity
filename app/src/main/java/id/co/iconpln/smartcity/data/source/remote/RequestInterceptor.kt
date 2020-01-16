package id.co.iconpln.insidal.network

import id.co.iconpln.smartcity.data.source.pref.AppPrefSource
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor(private val prefModule: AppPrefSource) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        var request: Request
        val requestBuilder = original.newBuilder()

        requestBuilder.addHeader("Authorization", "Bearer ${prefModule.getUser()?.token}")

        request = requestBuilder.build()

        return chain.proceed(request)
    }
}