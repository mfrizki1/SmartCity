package id.co.iconpln.smartcity.ui.kota

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiAdapter
import id.co.iconpln.smartcity.util.rx.SchedulerProvider

@Module
class KotaActivityModule {
    @Provides
    fun provideKotaPresenter(userRepository: UserRepository, provider: SchedulerProvider): KotaPresenter{
        return KotaPresenterImpl(userRepository, provider)
    }

    @Provides
    fun provideKotaAdapter(context: Context) = KotaAdapter(context)



}