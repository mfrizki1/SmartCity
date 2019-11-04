package id.co.iconpln.smartcity.di.module

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.data.source.pref.AppPrefSource
import id.co.iconpln.smartcity.data.source.remote.AppRemoteSource

/**
 * rizmaulana@live.com 2019-06-14.
 */

@Module
class RepositoryModule {

    @Provides
    fun provideUserRepository(prefSource: AppPrefSource, apiSource: AppRemoteSource) = UserRepository(apiSource, prefSource)
}