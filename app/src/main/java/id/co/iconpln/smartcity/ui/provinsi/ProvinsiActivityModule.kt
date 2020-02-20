package id.co.iconpln.smartcity.ui.provinsi

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

@Module
class ProvinsiActivityModule {
    @Provides
    fun provideProvinsiPresenter(userRepository: UserRepository, provider: SchedulerProvider) : ProvinsiPresenter{
        return ProvinsiPresenterImpl(userRepository, provider)
    }
    @Provides
    fun provideProvinsiAdapter(context: Context) = ProvinsiAdapter(context)
}