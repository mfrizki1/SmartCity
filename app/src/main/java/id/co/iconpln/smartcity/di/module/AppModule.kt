package id.co.iconpln.smartcity.di.module

import android.app.Application
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.R
import id.co.iconpln.smartcity.util.ValidatorUtils
import id.co.iconpln.smartcity.util.rx.AppSchedulerProvider
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: Application) : Context = application

    @Provides
    @Singleton
    internal fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/GoogleSans-Regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    internal fun provideLayoutManager(context: Context) = LinearLayoutManager(context)

    @Provides
    internal fun provideValidator(context: Context) = ValidatorUtils(context)




}