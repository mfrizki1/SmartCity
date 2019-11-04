package id.co.iconpln.smartcity.ui.splash

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

/**
 * rizmaulana@live.com 2019-06-16.
 */
@Module
class SplashActivityModule{
    @Provides
    fun provideSplashPresenter(userRepository: UserRepository, provider: SchedulerProvider) : SplashPresenter{
        return SplashPresenterImp(userRepository, provider)
    }
}