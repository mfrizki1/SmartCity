package id.co.iconpln.insidal.network

import android.content.Context
import com.orhanobut.hawk.Hawk
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject

class ResponseInterceptor @Inject constructor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val code = response.code()
        val bodyString = response.body()?.string()

        if (code == UNAUTHORIZED) {
            logout(code)
        }

        return response.newBuilder()
            .body(ResponseBody.create(response.body()?.contentType(), bodyString))
            .build()
    }

    private fun logout(causeType: Int) {
        if (causeType == UNAUTHORIZED) {
            Hawk.deleteAll()
           /* val intent = Intent(context.applicationContext, LoginActivity::class.java)
            intent.putExtra(LoginActivity.MESSAGE, context.getString(R.string.message_login_another_device))
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.applicationContext.startActivity(intent)*/
        }
    }

    companion object {
        val UNAUTHORIZED = 401
    }
}