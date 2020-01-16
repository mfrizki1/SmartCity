package id.co.iconpln.smartcity

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.orhanobut.hawk.Hawk
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import id.co.iconpln.smartcity.di.component.DaggerAppComponent
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import java.util.*
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-14.
 */
class AppController : Application(), HasActivityInjector {

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    internal lateinit var mCalligraphyConfig: CalligraphyConfig

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .app(this)
            .build()
            .inject(this)
        Locale.setDefault(Locale("in", "ID"))

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        Hawk.init(applicationContext).setLogInterceptor { message -> if (BuildConfig.DEBUG) Log.d("Hawk", message) }
                .build()

        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }

}