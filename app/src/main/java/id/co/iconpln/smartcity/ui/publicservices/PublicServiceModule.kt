package id.co.iconpln.smartcity.ui.publicservices

import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.JPengaduanImpl
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.JPengaduanPresenter
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.PengaduanPresenter
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.PengaduanPresenterImpl
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

@Module
class PublicServiceModule {

    @Provides
    fun providePengaduanPresenter(userRepository: UserRepository, provider: SchedulerProvider) : PengaduanPresenter =
        PengaduanPresenterImpl(userRepository, provider)

    @Provides
    fun provideJPengaduanPresenter(userRepository: UserRepository, provider: SchedulerProvider) : JPengaduanPresenter =
        JPengaduanImpl(userRepository, provider)

    @Provides
    fun providePublicService(userRepository: UserRepository, provider: SchedulerProvider) : PublicServicePresenter =
        PublicServiceImpl(userRepository, provider)

//    @Provides
//    fun provideJPengaduanPresenter(userRepository: UserRepository, provider: SchedulerProvider) : JPengaduanPresenter =
//        JPengaduanImp(userRepository, provider)
}
