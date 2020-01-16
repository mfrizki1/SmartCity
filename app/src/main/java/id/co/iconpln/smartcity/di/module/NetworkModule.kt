package id.co.iconpln.smartcity.di.module

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.BuildConfig
import id.co.iconpln.smartcity.data.source.remote.Api
import id.co.iconpln.smartcity.util.Constant
import id.co.iconpln.insidal.network.ApiFile
import id.co.iconpln.insidal.network.RequestInterceptor
import id.co.iconpln.insidal.network.ResponseInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun requestInterceptor(interceptor: RequestInterceptor) : Interceptor = interceptor

    @Provides
    @Singleton
    fun responseInterceptor(interceptor: ResponseInterceptor): Interceptor = interceptor

    @Provides
    @Singleton
    fun okHttp(requestInterceptor: RequestInterceptor, responseInterceptor: ResponseInterceptor) = OkHttpClient().newBuilder()
        .connectTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .addInterceptor(requestInterceptor)
        .addInterceptor(responseInterceptor)
        .build()

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun api(retrofit: Retrofit) = retrofit.create(Api::class.java)

    @Provides
    @Singleton
    @Named("retrofit_file")
    fun retrofitFile(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BuildConfig.FILE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun apiFile(@Named("retrofit_file") retrofit: Retrofit) = retrofit.create(ApiFile::class.java)

}