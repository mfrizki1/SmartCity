package id.co.iconpln.smartcity.di.module

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.source.pref.AppPrefSource
import javax.inject.Singleton

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Module
class PrefModule {

    @Singleton
    @Provides
    fun providesPrefSource() : AppPrefSource = AppPrefSource()


}