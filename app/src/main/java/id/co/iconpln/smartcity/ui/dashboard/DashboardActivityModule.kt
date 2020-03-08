package id.co.iconpln.smartcity.ui.dashboard

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

@Module
class DashboardActivityModule {

    @Provides
    fun provideDashPresenter(userRepository: UserRepository, provider: SchedulerProvider) : DashboardPresenter {
        return DashboardPresenterImpl(userRepository, provider)
    }

}
