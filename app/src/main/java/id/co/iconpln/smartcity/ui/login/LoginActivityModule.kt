package id.co.iconpln.smartcity.ui.login

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

/**
 * rizmaulana@live.com 2019-06-16.
 */
@Module
 class LoginActivityModule{

    @Provides
    fun provideLoginPresenter(userRepository: UserRepository, provider: SchedulerProvider) : LoginPresenter {
        return LoginPresenterImp(userRepository, provider)
    }
}