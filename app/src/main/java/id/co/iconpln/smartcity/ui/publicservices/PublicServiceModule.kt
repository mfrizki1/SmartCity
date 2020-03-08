package id.co.iconpln.smartcity.ui.publicservices

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

@Module
class PublicServiceModule {

    @Provides
    fun providePengaduanPresenter(userRepository: UserRepository, provider: SchedulerProvider) : PengaduanPresenter =
         PengaduanPresenterImpl(userRepository, provider)

}